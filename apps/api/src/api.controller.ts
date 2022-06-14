import { Controller, Get, Logger } from '@nestjs/common';
import { EventPattern, Transport } from '@nestjs/microservices';
import { ApiExcludeEndpoint } from '@nestjs/swagger';
import { CacheService } from '@sputnik-v2/cache';
import { NewNotificationDto, NewCommentDto } from '@sputnik-v2/event';
import {
  EVENT_DELETE_COMMENT,
  EVENT_NEW_COMMENT,
  EVENT_NEW_NOTIFICATION,
} from '@sputnik-v2/common';

import { SocketService } from './websocket/socket/socket.service';

@Controller()
export class AppController {
  private readonly logger = new Logger(AppController.name);

  constructor(
    private readonly cacheService: CacheService,
    private readonly socketService: SocketService,
  ) {}

  @ApiExcludeEndpoint()
  @Get()
  main(): string {
    return 'Sputnik v2 API v1.0';
  }

  @EventPattern(EVENT_NEW_NOTIFICATION, Transport.REDIS)
  async onNewNotification(data: NewNotificationDto) {
    this.logger.log(
      `Sending new notification ${data.notification.type} to Websocket clients.`,
    );
    this.socketService.emitToAllEvent({
      event: 'notification',
      data: data.notification,
    });
    this.logger.log(
      `Notification ${data.notification.type} sent to all websocket clients.`,
    );
    this.socketService.emitToAuthenticatedEvent({
      event: 'account-notification',
      accountEvents: data.accountNotifications,
    });
    this.logger.log(`Account Notification ${data.notification.type} sent.`);
  }

  @EventPattern(EVENT_NEW_COMMENT, Transport.REDIS)
  async onNewComment(data: NewCommentDto) {
    this.logger.log(
      `Sending new comment ${data.comment.id} to Websocket clients.`,
    );
    this.socketService.emitToAllEvent({
      event: 'comment',
      data: data.comment,
    });
    this.logger.log(
      `Notification for a new comment ${data.comment.id} sent to all websocket clients.`,
    );
  }

  @EventPattern(EVENT_DELETE_COMMENT, Transport.REDIS)
  async onDeleteComment(data: NewCommentDto) {
    this.logger.log(
      `Sending removed comment ${data.comment.id} to Websocket clients.`,
    );
    this.socketService.emitToAllEvent({
      event: 'comment-removed',
      data: data.comment,
    });
    this.logger.log(
      `Notification for removed comment ${data.comment.id} sent to all websocket clients.`,
    );
  }
}
