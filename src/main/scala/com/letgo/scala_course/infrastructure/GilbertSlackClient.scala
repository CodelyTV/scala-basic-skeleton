package com.letgo.scala_course.infrastructure

import scala.concurrent.{ExecutionContext, Future}

import akka.actor.ActorSystem
import slack.api.SlackApiClient

import com.letgo.scala_course.domain.{ChannelId, Message, SlackClient}

class GilbertSlackClient(implicit as: ActorSystem, ec: ExecutionContext) extends SlackClient {
  private val token  = sys.env("LETGO_SCALA_COURSE_SLACK_API_TOKEN")
  private val client = SlackApiClient(token)

  override def fetchChannelMessages(channelId: ChannelId): Future[Seq[Message]] = {

    client.getChannelHistory(channelId.rawChannelId).map { historyChunk =>
      historyChunk.messages.map { jsValue =>
        Message((jsValue \ "text").as[String])
      }
    }
  }

  override def addMessage(channel: ChannelId, message: Message): Future[_] = {
    client.postChatMessage(channel.rawChannelId, message.text)
  }
}
