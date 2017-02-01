package com.letgo.scala_course.application

import scala.concurrent.ExecutionContext

import com.letgo.scala_course.domain.{ChannelName, SlackClient}

class SlackMessagesFetcherUseCase(slackClient: SlackClient)(implicit ec: ExecutionContext) {
  def fetch(channelName: ChannelName): String = {
    val messagesFuture = slackClient.fetchChannelMessages(channelName)

    messagesFuture.foreach(messages => messages.foreach(println))

    "Fetching..."
  }
}
