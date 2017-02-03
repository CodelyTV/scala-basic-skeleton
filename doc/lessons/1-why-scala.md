# Why Scala

## OOP - Functional
* Promotes and makes it easier to handle immutability
* Immutable collection APIs by default
* Case Classes
```scala
case class Message(text: String)  
val helloMessage = Message("Hello")
  val byeMessage = helloMessage.copy(text = "Bye")
```
* Higher-order functions


## JVM performance and ecosystem


## Type inference (avoid Java verbosity) 
```scala
case class Message(text: String) { 
  def messageLength: Int = {
    val totalLength = text.length // Int inference
  
    totalLength
  }
}
```

## Easy to use async APIs (Future)


## Scala Ecosystem
* [Akka](http://akka.io/)
* [Kafka](https://kafka.apache.org/)
* [Spark](http://spark.apache.org/)
* [Play](https://www.playframework.com/)
* [Slick](http://slick.lightbend.com/)
* [ScalaTest](http://www.scalatest.org/)

