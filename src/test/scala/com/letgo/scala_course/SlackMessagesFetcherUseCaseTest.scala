package com.letgo.scala_course

import org.scalatest.{GivenWhenThen, WordSpec}
import org.scalatest.Matchers._

import com.letgo.scala_course.application.SlackMessagesFetcherUseCase

class SlackMessagesFetcherUseCaseTest extends WordSpec with GivenWhenThen {
  "SlackMessagesFetcher" should {
    "say hello" in {
      Given("a SlackMessagesFetcher")

      val fetcher = new SlackMessagesFetcherUseCase

      When("we ask him to fetch")

      val greeting = fetcher.fetch("#olakase")

      Then("he should say Fetching...")

      greeting shouldBe "Fetching..."
    }
  }
}
