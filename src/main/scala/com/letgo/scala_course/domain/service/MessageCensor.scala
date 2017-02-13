package com.letgo.scala_course.domain.service

import com.letgo.scala_course.domain.Message

class MessageCensor(forbiddenKeywords: Set[String]) {

  private val filterRule: Message => Message = { message =>
    Message(message.text.split(" ").filterNot(isWordForbidden).mkString(" "))
  }

  private def isWordForbidden(word: String): Boolean = forbiddenKeywords.contains(word)

  def filterMessages(messages: Seq[Message]): Seq[Message] = messages.map(filterRule)
}
