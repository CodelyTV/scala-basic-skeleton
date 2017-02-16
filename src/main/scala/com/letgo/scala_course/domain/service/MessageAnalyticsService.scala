package com.letgo.scala_course.domain.service

import com.letgo.scala_course.domain.{Message, UserMessage, UserName}

class MessageAnalyticsService {

  def countMessagesOfUser(messages: Seq[UserMessage], userName: UserName): Int = {
    messages.count(_.userName == userName)
  }

  def groupBy(messages: Seq[UserMessage]): Map[UserName, Seq[Message]] = {
    Map()
  }
}
