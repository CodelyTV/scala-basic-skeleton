#Basic syntax

The first thing you need to do is start the Scala REPL.

In order to do so, just move to your repository directory `cd scala_course`, and enter inside SBT with `sbt`. 

Once we're inside SBT, we can open an Scala REPL just typing `console`.

##Functions

In order to view the syntax of a function, we're going to create a function
that receives an `Int` as a parameter and returns this value incremented by 1.

Here we have the example:

```scala
def sum(value: Int): Int = {
  value + 1
}
```

Now we can declare this function inline!

```scala
def sum(value: Int): Int = value + 1
```

And, finally, we can also declare it with a default value (not much necessary in this case :joy:)

```scala
def sum(value: Int = 5): Int = value + 1
```

##Classes

In this chapter of this course, we'll see two kind of classes: standard classes and case classes

We're going to declare a `class Animal` with two parameters:

```scala
class Animal(name: String, weigth: Double) {
  
}
```

In this case, we have an instance of `Animal`, but we cannot access to the values of name or weigth,
so we have to implement his getters:

```scala
class Animal(name: String, weight: Double) {
  def getName: String = name
  
  def getWeight: Double = weight
}

val animal = new Animal("elephant", 1205.35)

val weight = animal.getWeight
```
As we can see, we can get the value of the parameters, but imagine you have a class
with 10 parameters... so hateful!

To simplify it, we have our loved case classes!

```scala
case class Animal(name: String, weight: Double)

val animal = Animal("crocodile", 223.59)

val weight = animal.weight
```

More simple and less code, isn't it?

#Types

As you could see at the slides, Scala is a very typed language with lots of
types, and everything is an object with a type.

To see type safe in Scala we're going to declare a variable of type `Int`
and consider to overwrite it with an `String`:
```scala
var ourNumber: Int = 5

ourNumber = "String" // Type mismatch!! Try it in the REPL to see the full error
```

This strict type saves us of many bugs on our code!

We'll try to declare a var of type Any, set it with an Int and replace it with
an String

```scala
var ourNumber: Any = 5

ourNumber = "String"
```

If you try it in the REPL, you'll see that there's no error, but it is not recommended
to use so much generic types. The more concrete you are, the safer your code is.
