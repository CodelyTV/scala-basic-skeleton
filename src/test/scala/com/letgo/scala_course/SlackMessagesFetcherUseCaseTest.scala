package com.letgo.scala_course

import akka.actor.ActorSystem
import org.scalatest.Matchers._
import org.scalatest.{GivenWhenThen, WordSpec}

import com.letgo.scala_course.application.SlackMessagesFetcherUseCase
import com.letgo.scala_course.domain.ChannelName
import com.letgo.scala_course.infrastructure.GilbertSlackClient

class SlackMessagesFetcherUseCaseTest extends WordSpec with GivenWhenThen {
  implicit private val actorSystem      = ActorSystem("test-actor-system")
  implicit private val executionContext = scala.concurrent.ExecutionContext.global

  private val slackMessagesFetcherUseCase = new SlackMessagesFetcherUseCase(new GilbertSlackClient)

  "SlackMessagesFetcher" should {
    "say hello" in {
      Given("a SlackMessagesFetcher")

      val fetcher = slackMessagesFetcherUseCase

      And("an existing channel name")

      val channelName = ChannelName("#random")

      When("we fetch the channel messages")

      val messages = fetcher.fetch(channelName)

      Then("it should return Fetching...")

      messages shouldBe "Fetching..."
    }
  }
}
