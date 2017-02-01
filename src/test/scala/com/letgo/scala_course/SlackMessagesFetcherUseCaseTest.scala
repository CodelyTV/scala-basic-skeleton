package com.letgo.scala_course

import akka.actor.ActorSystem
import org.scalatest.{GivenWhenThen, WordSpec}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.Matchers._
import org.scalatest.time.{Millis, Seconds, Span}

import com.letgo.scala_course.application.SlackMessagesFetcherUseCase
import com.letgo.scala_course.domain.ChannelId
import com.letgo.scala_course.infrastructure.GilbertSlackClient

class SlackMessagesFetcherUseCaseTest extends WordSpec with GivenWhenThen with ScalaFutures{
  implicit private val actorSystem      = ActorSystem("test-actor-system")
  implicit private val executionContext = scala.concurrent.ExecutionContext.global

  implicit override val patienceConfig = PatienceConfig(
    timeout = scaled(Span(3, Seconds)),
    interval = scaled(Span(100, Millis))
  )

  private val slackMessagesFetcherUseCase = new SlackMessagesFetcherUseCase(new GilbertSlackClient)

  "SlackMessagesFetcher" should {
    "say hello" in {
      Given("a SlackMessagesFetcher")

      val fetcher = slackMessagesFetcherUseCase

      And("an existing channel name")

      val scalaCourseChannelId = ChannelId("C3YPYMQ2D")

      When("we fetch the channel messages")

      val messages = fetcher.fetch(scalaCourseChannelId)

      Then("it should return Fetching...")

      messages.futureValue shouldBe "Fetching..."
    }
  }
}
