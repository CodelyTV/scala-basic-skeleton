package com.letgo.scala_course.application

import scala.concurrent.{ExecutionContext, Future}

import com.letgo.scala_course.domain.{ChannelId, Message, SlackClient}

class SlackMessagesFetcherUseCase(slackClient: SlackClient)(implicit ec: ExecutionContext) {
  val numberOfApiCalls: Int = 1

  var cache: Option[Future[Seq[Message]]] = None

  def fetch(channelName: ChannelId): Future[Seq[Message]] =
    slackClient.fetchChannelMessages(channelName)

  def fetchWithCache(channelName: ChannelId): Future[Seq[Message]] =
    slackClient.fetchChannelMessages(channelName)
}
