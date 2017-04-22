package com.letgo.scala_course

import org.scalatest.Matchers._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.{GivenWhenThen, WordSpec}

import com.letgo.scala_course.domain.service.MessageCensor
import com.letgo.scala_course.domain.Message

class MessageCensorTest extends WordSpec with GivenWhenThen with ScalaFutures {

  implicit override val patienceConfig = PatienceConfig(
    timeout = scaled(Span(3, Seconds)),
    interval = scaled(Span(100, Millis))
  )

  "MessageCensorTest" should {
    "censor bad language" in {
      Given("a MessageCensorTest")

      val forbiddenKeywords = Set("fuck", "jorge")
      val censor = new MessageCensor(forbiddenKeywords)

      val myMessages = Seq(
        Message("go fuck yourself"),
        Message("i love jorge")
      )

      val expectedCensoredMessages = Seq(
        Message("go yourself"),
        Message("i love")
      )

      val censoredMessages = censor.filterMessages(myMessages)

      censoredMessages should be(expectedCensoredMessages)
    }
  }
}
