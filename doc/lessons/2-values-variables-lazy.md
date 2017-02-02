# Variables, functions, values, and lazy values 

## Starting the Scala REPL

The first thing you need to do is start the Scala REPL.

In order to do so, just move to your repository directory `cd scala_course`, and enter inside SBT with `sbt`. Once we're inside SBT, we can open an Scala REPL just typing `console`. This REPL will include the dependencies we've added to our project :speak_no_evil: .

## Message class

We will play a little bit with a `Message` class which just represents that, a text message. In order to declare this class, you have to type the following declaration inside the Scala REPL and hit enter.

```scala
case class Message(text: String)
```

## Variables

Now we're ready to start playing with the different Scala constructions. 

Firstly we're gonna see the most common construction in other languages: Variables.

This kind of construction just let you declare some value that will be able to change over time.

Example (feel free to copy and paste it on your REPL in order to play a little):
```scala
var questionMessage = Message("Ola k ase?") // questionMessage: Message = Message(Ola k ase?)

questionMessage = Message("No ase nada?") // questionMessage: Message = Message(No ase nada?)
```

## Immutable values

Now that we know how to declare variables, let's go one step forward and discover the `val` construction.

The values are just variables declared as final. That is, we can not set another value once it has been declared.

That bring to us to the immutability concept. We'll try to be as immutable as we can, therefore, we'll use `val` over `var` as much as we can :)

Example:
```scala
val helloMessage = Message("Hello")

helloMessage = Message("lele") // error: reassignment to val
```

### Immutable values + Mutable classes 

Keep in mind that despite of not being able to change the reference of `helloMessage` to another different object, the assigned object in the declaration could be mutable by itself.
 
That is, if the `Message` would be a mutable class (with setters for its `text` field), it would be possible to modify the internal value, but never the reference of a `val`.

Example of the non recommended approach:
```scala
case class MutableMessage(var text: String)

val lereleMessage = MutableMessage("initial value of MutableMessage text")

lereleMessage.text = "Second value for the MutableMessage text"

println(lereleMessage) // MutableMessage(Second value for the MutableMessage text)
```

### Immutable values + Immutable classes

However, we could declare our classes also as immutable representations of a desired state. This way, we will be able to be fully immutable (from the point of view of the reference, and the state):

```scala
case class ImmutableMessage(text: String) // The fields defined in a `case class` are `val`s by default

val loroloMessage = ImmutableMessage("initial value of ImmutableMessage text")

loroloMessage.text = "Second value for the ImmutableMessage text" // error: reassignment to val
```

## Lazy immutable values

Take into account that the assignments could be as complex as we want to. That is, we can also use the block construction in order to define a value since blocks always return the last statement on it:
```scala
lazy val lazyMessage = {
  println("We're inside the lazyMessage definition")
  
  Message("lazy message")
} // lazyMessage: Message = <lazy>

lazyMessage // We're inside the lazyMessage definition
            // res0: Message = Message(lazy message)
```

Take a look at the difference with the standard `val` declaration:
```scala
val standardMessage = {
  println("We're inside the standardMessage definition")
  
  Message("standarad message")
} // We're inside the standardMessage definition.
  // standardMessage: Message = Message(standarad message)

standardMessage // res1: Message = Message(standarad message)
```

The difference is subtle but important: The `println` located inside the message assignment is not executed until we call to the `lazyMessage` in the first example.

## Functions

Now that we've learned how to declare immutable values, let's get into method declaration.

The only difference between a method and a value, is the keyword used in order to declare it (`def` over `val). The rest of the definition structure will be the same.

The particularity that differentiates a function from a value, is that it will be executed on each invocation. We've seen that `val`s are only executed when they're initialized, and `lazy val`s are only executed when we call them for the first time.

Let's put all together and play a little with the expected behaviour of each kind of construction:
```scala
val hiMessage = Message("Hi")

val byeMessage = Message("Bye")

val allMessages = Seq(hiMessage, byeMessage)

val randomMessageAsVal: Message = allMessages(scala.util.Random.nextInt(allMessages.size))

lazy val randomMessageAsLazyVal: Message = allMessages(scala.util.Random.nextInt(allMessages.size))

def randomMessageAsDef: Message = allMessages(scala.util.Random.nextInt(allMessages.size))

randomMessageAsVal // It will be always the same message. It has been initialized when it has been declared.
randomMessageAsVal
randomMessageAsVal

randomMessageAsLazyVal // It will be always the same message. It is being initialized in this very first call.
randomMessageAsLazyVal
randomMessageAsLazyVal

randomMessageAsDef // It could be a different message on each call. It's executed every time it's called.
randomMessageAsDef
randomMessageAsDef
```

## Conclusion

* Use `val` over `var` because it's immutable (we're gonna dig a little over why immutability is good in further lessons).
* `val`s are executed only once. Use them for constant values or expressions (remind that you can use the block construction).
* `lazy val`s doesn't initialize the value until it's needed for the first time. 
* `lazy val`s hide initialization costs. This could be seen as something bad. Take that into account while using them.
* `def`s are executed each time it's being called. Use it for non constant values.

## Exercise

Now that you know all about `var`, `val`, `lazy val`, and `def`, let's put them into usage with an example closer to our daily basis tasks :)
  
We've already developed for you the skeleton of a use case in order to interact with the Slack API.

### Starting up the environment

You will have to get an Slack API access token and set it as an environment variable (explained in [the README.md of this repo](../../README.md#how-to-start)). Once you do that, you should be able to execute the test from the `sbt`:

`to com.letgo.scala_course.SlackMessagesFetcherUseCaseTest`

Take a look at [the #scala-course Slack channel](https://letgoapp.slack.com/archives/scala-course), you should have published a message to it!

### ToDo

Right now, the `com.letgo.scala_course.application.SlackMessagesFetcherUseCase.fetch` method goes to the Slack API on each invocation. Try to improve it applying an counter, and a cache.
 
#### API calls counter

You have to make the `increment the number of calls to the Slack API when executing it` test pass.

Suggested starting point:
* Execute this single test: `to com.letgo.scala_course.SlackMessagesFetcherUseCaseTest -- -z "increment"`.
* Apply the needed modifications in order to update the `numberOfApiCalls` when we call to `fetch`.

#### API calls cache

You have to make the `only call once to the API even if we execute it twice when we use cache` test pass.

Suggested starting point:
* Execute this single test: `to com.letgo.scala_course.SlackMessagesFetcherUseCaseTest -- -z "cache"`.
* Apply the needed modifications in order to update the `numberOfApiCalls` when we call to `fetchWithCache`.
* Apply the needed modifications in order to store the results of the `fetchWithCache` method in the `cache` for the second time it's called.
