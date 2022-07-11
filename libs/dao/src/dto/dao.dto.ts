import { TransactionInfo } from '@sputnik-v2/common';

import { DaoConfig, DaoStatus } from '../types';
import { PolicyDtoV1, PolicyDtoV2 } from './policy.dto';

export interface DaoDto extends TransactionInfo {
  id: string;
  amount: number;
  config: DaoConfig;
  totalSupply: string;
  stakingContract: string;
  council: string[];
  policy: PolicyDtoV1;
  link: string;
  description: string;
  createdBy: string;
  metadata?: Record<string, any>;
  status?: DaoStatus;
}
