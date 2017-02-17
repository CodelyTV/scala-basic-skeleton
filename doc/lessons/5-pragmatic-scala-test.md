# Pragmatic Scala test

## Where do we locate the tests?

By convention the tests are located under src/test/scala

## ScalaTest

ScalaTest is a library similar to PhpUnit or JUnit to write tests in a fluent way in Scala.

## Writing a test

First of all you have to choose the semantic level required for your test. You can see it at this [link](http://www.scalatest.org/user_guide/selecting_a_style)
To do assertions in a idiomatic way is required to extend your class from [Matchers](http://www.scalatest.org/user_guide/using_matchers).

Test example:

```java
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
```

## Execute the tests
To execute your tests from sbt you can write: 

* test
* testOnly <qualified_name_test>

Or to execute a specific test case inside a test, you can write:

* testOnly <qualified_name_test> -- -z <test_case>
