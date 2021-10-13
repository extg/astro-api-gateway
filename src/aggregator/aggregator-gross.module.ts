import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ScheduleModule } from '@nestjs/schedule';
import configuration, {
  TypeOrmConfigService,
  validate,
} from '../config/aggregator-config';
import { DaoSlimModule } from 'src/daos/dao-slim.module';
import { ProposalSlimModule } from 'src/proposals/proposal-slim.module';
import { NearModule } from 'src/near/near.module';
import { TransactionModule } from 'src/transactions/transaction.module';
import { SputnikDaoService } from 'src/sputnikdao/sputnik.service';
import { AggregatorGrossService } from './aggregator-gross.service';
import { EventModule } from 'src/events/events.module';
import { ConfigModule } from '@nestjs/config';
import { BountySlimModule } from 'src/bounties/bounty-slim.module';
import { TokenFactoryService } from 'src/token-factory/token-factory.service';
import { TokenSlimModule } from 'src/tokens/token-slim.module';
import { AggregatorValidationSchema } from 'src/config/validation/aggregator.schema';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
      load: configuration,
      validate: (config) => validate(AggregatorValidationSchema, config),
      envFilePath: ['.env.local', '.env'],
    }),
    TypeOrmModule.forRootAsync({
      useClass: TypeOrmConfigService,
    }),
    ScheduleModule.forRoot(),
    DaoSlimModule,
    ProposalSlimModule,
    NearModule,
    TransactionModule,
    EventModule,
    BountySlimModule,
    TokenSlimModule,
  ],
  providers: [
    SputnikDaoService,
    TokenFactoryService,
    AggregatorGrossService,
  ],
})
export class AggregatorGrossModule {}
