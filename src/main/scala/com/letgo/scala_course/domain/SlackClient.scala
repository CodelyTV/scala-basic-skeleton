package com.letgo.scala_course.domain

import scala.concurrent.Future

trait SlackClient {
  def fetchChannelMessages(channel: ChannelName): Future[Seq[Message]]
}
