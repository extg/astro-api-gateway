import { ApiProperty } from '@nestjs/swagger';
import { TransactionEntity } from 'src/common/transaction.entity';
import { Dao } from 'src/daos/entities/dao.entity';
import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  OneToMany,
  PrimaryColumn,
} from 'typeorm';
import { BountyClaim } from './bounty-claim.entity';

@Entity()
export class Bounty extends TransactionEntity {
  @ApiProperty()
  @PrimaryColumn({ type: 'text', unique: true })
  id: string;

  @ApiProperty()
  @Column()
  bountyId: number;

  @ApiProperty()
  @Column()
  daoId: string;

  @ApiProperty({ type: Dao })
  @ManyToOne((_) => Dao, { eager: true })
  @JoinColumn({ name: 'dao_id' })
  dao: Dao;

  @ApiProperty({ type: [BountyClaim] })
  @OneToMany(() => BountyClaim, (claim) => claim.bounty, {
    cascade: true,
    persistence: false,
  })
  bountyClaims: BountyClaim[];

  @ApiProperty()
  @Column()
  description: string;

  @ApiProperty()
  @Column()
  token: string;

  @ApiProperty()
  @Column()
  amount: string;

  @ApiProperty()
  @Column()
  times: string;

  @ApiProperty()
  @Column()
  maxDeadline: string;

  @ApiProperty()
  @Column()
  numberOfClaims: number;
}
