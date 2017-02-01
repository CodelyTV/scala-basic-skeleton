package com.letgo.scala_course.infrastructure

import scala.concurrent.{ExecutionContext, Future}

import akka.actor.ActorSystem
import slack.api.SlackApiClient

import com.letgo.scala_course.domain.{ChannelName, Message, SlackClient}

class GilbertSlackClient(implicit as: ActorSystem, ec: ExecutionContext) extends SlackClient {
  private val token  = sys.env("LETGO_SCALA_COURSE_SLACK_API_TOKEN")
  private val client = SlackApiClient(token)

  override def fetchChannelMessages(channel: ChannelName): Future[Seq[Message]] = {
    client.getChannelHistory(channel.channelName).map { historyChunk =>
      historyChunk.messages.map(jsValue => Message(jsValue.toString()))
    }
  }
}
