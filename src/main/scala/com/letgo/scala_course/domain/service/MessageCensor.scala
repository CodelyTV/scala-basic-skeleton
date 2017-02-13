package com.letgo.scala_course.domain.service

import com.letgo.scala_course.domain.Message

class MessageCensor(forbiddenKeywords: Set[String]) {

  private val filterRule: Message => Message = ???

  def filterMessages(messages: Seq[Message]): Seq[Message] = messages.map(filterRule)
}

