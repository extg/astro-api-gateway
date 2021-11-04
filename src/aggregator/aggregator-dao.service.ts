import { Injectable, Logger } from '@nestjs/common';
import { DaoService } from 'src/daos/dao.service';
import { SputnikDaoService } from 'src/sputnikdao/sputnik.service';
import { isNotNull } from 'src/utils/guards';
import { NearService } from 'src/near/near.service';
import { TransactionService } from 'src/transactions/transaction.service';
import { ConfigService } from '@nestjs/config';
import { SchedulerRegistry } from '@nestjs/schedule';
import { EventService } from 'src/events/events.service';
import { AccountChangeService } from 'src/transactions/account-change.service';
import { AccountChange } from 'src/near/entities/account-change.entity';
import { ProposalService } from 'src/proposals/proposal.service';
import { CacheService } from 'src/cache/service/cache.service';

@Injectable()
export class AggregatorDaoService {
  private readonly logger = new Logger(AggregatorDaoService.name);

  constructor(
    private readonly configService: ConfigService,
    private readonly sputnikDaoService: SputnikDaoService,
    private readonly daoService: DaoService,
    private readonly proposalService: ProposalService,
    private readonly nearService: NearService,
    private readonly transactionService: TransactionService,
    private readonly accountChangeService: AccountChangeService,
    private readonly eventService: EventService,
    private readonly schedulerRegistry: SchedulerRegistry,
    private readonly cacheService: CacheService,
  ) {
    const { pollingInterval, proposalVoteStatusUpdateInterval } =
      this.configService.get('aggregator-dao');

    const daoInterval = setInterval(
      () => this.scheduleAggregation(),
      pollingInterval,
    );
    schedulerRegistry.addInterval('polling', daoInterval);

    const proposalInterval = setInterval(
      () => this.scheduleProposalVoteStatusUpdate(),
      proposalVoteStatusUpdateInterval,
    );
    schedulerRegistry.addInterval(
      'proposal-vote-update-schedule',
      proposalInterval,
    );
  }

  public async scheduleAggregation(): Promise<void> {
    const accChange = await this.accountChangeService.lastAccountChange();
    if (!accChange) {
      // Skipping cron job scheduling until the very 1st aggregation completes.
      return;
    }

    this.logger.debug('Scheduling Data Aggregation...');

    return this.aggregate(accChange);
  }

  public async aggregate(lastAccChange?: AccountChange): Promise<void> {
    const { contractName } = this.configService.get('near');

    this.logger.debug('Checking data relevance...');
    const accChange =
      lastAccChange || (await this.accountChangeService.lastAccountChange());

    let blockTimestamp = accChange?.changedInBlockTimestamp;
    if (!blockTimestamp) {
      const tx = await this.transactionService.lastTransaction();

      blockTimestamp = tx?.blockTimestamp;
    }

    const nearAccChange =
      await this.nearService.findLastAccountChangesByContractName(
        contractName,
        blockTimestamp,
      );

    if (
      accChange &&
      accChange.changedInBlockTimestamp ===
        nearAccChange?.changedInBlockTimestamp
    ) {
      return this.logger.debug('Data is up to date. Skipping data aggregation.');
    }

    const accountChanges =
      await this.nearService.findAccountChangesByContractName(
        contractName,
        blockTimestamp,
      );

    const updatedDaoIds = Array.from(
      new Set(accountChanges.map(({ affectedAccountId }) => affectedAccountId)),
    );

    this.logger.log(`DAOs updated: ${updatedDaoIds.join(',')}`);
    this.eventService.sendDaoUpdateNotificationEvent(updatedDaoIds);

    let startTime = new Date().getTime();
    const [daos] = await Promise.all([
      this.sputnikDaoService.getDaoList(updatedDaoIds),
    ]);
    const aggregationTime = new Date().getTime();
    this.logger.log(
      `Smart Contract aggregation time: ${aggregationTime - startTime} ms`,
    );

    this.logger.log('Persisting aggregated DAOs...');
    await Promise.all(
      daos
        .filter((dao) => isNotNull(dao))
        .map((dao) => this.daoService.create(dao)),
    );
    this.logger.log('Finished DAO aggregation.');

    this.logger.log('Persisting aggregated Account Changes...');
    await Promise.all(
      accountChanges.map((accountChange) =>
        this.accountChangeService.create(accountChange),
      ),
    );
    this.logger.log('Finished Account Changes aggregation.');

    this.logger.log('Sending DAO updates...');
    this.eventService.sendDaoUpdates(daos);
  }

  public async scheduleProposalVoteStatusUpdate(): Promise<void> {
    const updateResult = await this.proposalService.updateExpiredProposals();

    if (updateResult?.affected) {
      this.logger.log(
        `Updated ${updateResult.affected} Proposals - Vote Status Expired.`,
      );

      this.logger.log(`Clearing cache on Proposal Expiration.`);
      await this.cacheService.clearCache();
    }
  }
}
