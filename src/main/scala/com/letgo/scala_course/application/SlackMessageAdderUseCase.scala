package com.letgo.scala_course.application

import scala.concurrent.{ExecutionContext, Future}

import com.letgo.scala_course.domain.{ChannelId, Message, SlackClient}

class SlackMessageAdderUseCase(slackClient: SlackClient)(implicit ec: ExecutionContext) {
  def add(channel: ChannelId, message: Message): Future[_] = {
    slackClient.addMessage(channel, message)
  }
}
