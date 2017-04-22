package com.letgo.scala_course.domain

import scala.concurrent.Future

trait SlackClient {
  def fetchChannelMessages(channel: ChannelId): Future[Seq[Message]]
  def addMessage(channel: ChannelId, message: Message): Future[_]
}
