package com.letgo.scala_course

import akka.actor.ActorSystem
import org.scalatest.{GivenWhenThen, WordSpec}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.Matchers._
import org.scalatest.time.{Millis, Seconds, Span}

import com.letgo.scala_course.application.{SlackMessageAdderUseCase, SlackMessagesFetcherUseCase}
import com.letgo.scala_course.domain.{ChannelId, Message}
import com.letgo.scala_course.infrastructure.GilbertSlackClient

class SlackMessagesFetcherUseCaseTest extends WordSpec with GivenWhenThen with ScalaFutures {
  implicit private val actorSystem      = ActorSystem("test-actor-system")
  implicit private val executionContext = scala.concurrent.ExecutionContext.global

  implicit override val patienceConfig = PatienceConfig(
    timeout = scaled(Span(3, Seconds)),
    interval = scaled(Span(100, Millis))
  )

  private val client                      = new GilbertSlackClient
  private def slackMessagesFetcherUseCase = new SlackMessagesFetcherUseCase(client)
  private def slackMessageAdderUseCase    = new SlackMessageAdderUseCase(client)

  "SlackMessagesFetcher" should {
    "fetch the last message published to a channel" in {
      Given("a SlackMessagesFetcher")

      val fetcher = slackMessagesFetcherUseCase

      And("an existing channel name")

      val scalaCourseChannelId = ChannelId("C3YPYMQ2D")

      And("a published message to the channel")

      val message = Message("letgo")
      slackMessageAdderUseCase.add(scalaCourseChannelId, message).futureValue

      When("we fetch the channel messages")

      val messages = fetcher.fetch(scalaCourseChannelId)

      Then("it should return the last added one")

      messages.futureValue.head shouldBe message
    }

    "increment the number of calls to the Slack API when executing it" in {
      Given("a SlackMessagesFetcher")

      val fetcher = slackMessagesFetcherUseCase

      And("an existing channel name")

      val scalaCourseChannelId = ChannelId("C3YPYMQ2D")

      When("we fetch the channel messages twice")

      fetcher.fetch(scalaCourseChannelId).futureValue
      fetcher.fetch(scalaCourseChannelId).futureValue

      Then("it should count the 2 calls")

      fetcher.numberOfApiCalls shouldBe 2
    }

    "only call once to the API even if we execute it twice when we use cache" in {
      Given("a SlackMessagesFetcher")

      val fetcher = slackMessagesFetcherUseCase

      And("an existing channel name")

      val scalaCourseChannelId = ChannelId("C3YPYMQ2D")

      When("we fetch with cache the channel messages twice")

      fetcher.fetchWithCache(scalaCourseChannelId).futureValue
      fetcher.fetchWithCache(scalaCourseChannelId).futureValue

      Then("it should count the only call")

      fetcher.numberOfApiCalls shouldBe 1
      fetcher.cache should not be empty
    }
  }
}
