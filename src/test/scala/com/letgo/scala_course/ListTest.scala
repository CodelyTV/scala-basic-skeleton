package com.letgo.scala_course

import org.scalatest.{Matchers, WordSpec}

/**
  * Test used to explain the test lesson
  */
final class ListTest extends WordSpec with Matchers {
  "A List" should {
    "have a size of zero when it's created as empty" in {
      val emptyList: List[Int] = List.empty[Int]
      emptyList.size shouldBe 0
    }

    "have size of one when it's created with a single element" in {
      val listWithOneElement: List[String] = List("some string")
      listWithOneElement.size shouldBe 1
    }

    "contain an element when it's created with that element inside" in {
      case class SomeCaseClass(someValue: Int)

      val someCaseClass   = SomeCaseClass(10)
      val listWithElement = List(someCaseClass)
      listWithElement.contains(someCaseClass) shouldBe true
    }
  }
}
