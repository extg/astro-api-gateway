import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ScheduleModule } from '@nestjs/schedule';
import configuration, {
  TypeOrmConfigService,
  validate,
} from '../config/aggregator-dao-config';
import { DaoSlimModule } from 'src/daos/dao-slim.module';
import { ProposalSlimModule } from 'src/proposals/proposal-slim.module';
import { NearIndexerModule } from 'src/near-indexer/near-indexer.module';
import { NearApiModule } from 'src/near-api/near-api.module';
import { TransactionModule } from 'src/transactions/transaction.module';
import { SputnikDaoService } from 'src/sputnikdao/sputnik.service';
import { AggregatorDaoService } from './aggregator-dao.service';
import { EventModule } from 'src/events/events.module';
import { ConfigModule } from '@nestjs/config';
import { BountySlimModule } from 'src/bounties/bounty-slim.module';
import { TokenFactoryService } from 'src/token-factory/token-factory.service';
import { TokenSlimModule } from 'src/tokens/token-slim.module';
import { AggregatorDaoValidationSchema } from 'src/config/validation/aggregator-dao.schema';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
      load: configuration,
      validate: (config) => validate(AggregatorDaoValidationSchema, config),
      envFilePath: ['.env.local', '.env'],
    }),
    TypeOrmModule.forRootAsync({
      useClass: TypeOrmConfigService,
    }),
    ScheduleModule.forRoot(),
    DaoSlimModule,
    ProposalSlimModule,
    NearIndexerModule,
    NearApiModule,
    TransactionModule,
    EventModule,
    BountySlimModule,
    TokenSlimModule,
  ],
  providers: [SputnikDaoService, TokenFactoryService, AggregatorDaoService],
})
export class AggregatorDaoModule {}
