package com.letgo.scala_course

import org.scalatest.{Matchers, WordSpec}

import com.letgo.scala_course.domain.{Message, UserMessage, UserName}
import com.letgo.scala_course.domain.service.MessageAnalyticsService

class MessageAnalyticsServiceTest extends WordSpec with Matchers {

  "MessageAnalyticsService" should {

    "group empty messages by user" in {

      val msgAnalyticsService = new MessageAnalyticsService()

      msgAnalyticsService.groupByUserName(Seq.empty) should contain theSameElementsAs Map.empty
    }

    "group single message by user" in {

      val msgAnalyticsService = new MessageAnalyticsService()

      msgAnalyticsService.groupByUserName(
        Seq(
          UserMessage(
            UserName("Jorge Avila"),
            Message("Me tengo que pelar")
          )
        )
      ) should contain theSameElementsAs Map(UserName("Jorge Avila") -> Seq(Message("Me tengo que pelar")))
    }

    "group messages by user" in {

      val msgAnalyticsService = new MessageAnalyticsService()

      msgAnalyticsService.groupByUserName(
        Seq(
          UserMessage(
            UserName("Jorge Avila"),
            Message("Me tengo que pelar")
          ),
          UserMessage(
            UserName("SergiGP"),
            Message("La burbuja va a estallar")
          ),
          UserMessage(
            UserName("SergiGP"),
            Message("Ya llegareis")
          ),
          UserMessage(
            UserName("Dani De Ripo"),
            Message("El TT es un iman...")
          ),
          UserMessage(
            UserName("JaviCane"),
            Message("Cosa fina")
          ),
          UserMessage(
            UserName("Jorge Avila"),
            Message("Yo fui a las pruebas de la Real")
          )
        )
      ) should contain theSameElementsAs Map(
        UserName("Jorge Avila") -> Seq(
          Message("Me tengo que pelar"),
          Message("Yo fui a las pruebas de la Real")
        ),
        UserName("SergiGP") -> Seq(
          Message("La burbuja va a estallar"),
          Message("Ya llegareis")
        ),
        UserName("Dani De Ripo") -> Seq(
          Message("El TT es un iman...")
        ),
        UserName("JaviCane") -> Seq(
          Message("Cosa fina")
        )
      )
    }

  }
}
