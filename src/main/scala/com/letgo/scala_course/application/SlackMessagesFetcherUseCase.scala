package com.letgo.scala_course.application

import scala.concurrent.{ExecutionContext, Future}

import com.letgo.scala_course.domain.{ChannelId, Message, SlackClient}

class SlackMessagesFetcherUseCase(slackClient: SlackClient)(implicit ec: ExecutionContext) {
  var numberOfApiCalls: Int = 0

  var cache: Option[Future[Seq[Message]]] = None

  def fetch(channelName: ChannelId): Future[Seq[Message]] = {
    numberOfApiCalls += 1
    slackClient.fetchChannelMessages(channelName)
  }

  def fetchWithCache(channelName: ChannelId): Future[Seq[Message]] = cache.getOrElse {
      val message = fetch(channelName)
      cache = Some(message)

      message
    }
}
