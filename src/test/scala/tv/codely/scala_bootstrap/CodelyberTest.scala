package tv.codely.scala_bootstrap

import org.scalatest._
import org.scalatest.Matchers._

final class CodelyberTest extends WordSpec with GivenWhenThen {

  "Codelyber" should {
    "say hello" in {
      Given("a Codelyber")

      val codelyber = Codelyber("Javi")

      When("we ask him to greet")

      val greeting = codelyber.greet()

      Then("he should say hello")

      greeting shouldBe "Hello"
    }
  }
}
