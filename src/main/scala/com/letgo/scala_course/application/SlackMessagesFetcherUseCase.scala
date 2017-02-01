package com.letgo.scala_course.application

import scala.concurrent.{ExecutionContext, Future}

import com.letgo.scala_course.domain.{ChannelId, Message, SlackClient}

class SlackMessagesFetcherUseCase(slackClient: SlackClient)(implicit ec: ExecutionContext) {
  def fetch(channelName: ChannelId): Future[Seq[Message]] =
    slackClient.fetchChannelMessages(channelName)
}
