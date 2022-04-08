import { IsEnum, IsNotEmpty, IsString } from 'class-validator';
import { DatabaseValidationSchema } from './db.schema';

enum NotifiEnvironment {
  Development = 'Development',
  Production = 'Production',
}

export class NotifierValidationSchema extends DatabaseValidationSchema {
  @IsString()
  @IsNotEmpty()
  FIREBASE_PROJECT_ID: string;

  @IsString()
  @IsNotEmpty()
  FIREBASE_CLIENT_EMAIL: string;

  @IsString()
  @IsNotEmpty()
  FIREBASE_PRIVATE_KEY: string;

  @IsString()
  @IsNotEmpty()
  NOTIFI_SID: string;

  @IsString()
  @IsNotEmpty()
  NOTIFI_SECRET: string;

  @IsEnum(NotifiEnvironment)
  @IsNotEmpty()
  NOTIFI_ENV: NotifiEnvironment;

  @IsString()
  @IsNotEmpty()
  NOTIFI_PREFIX: string;
}
