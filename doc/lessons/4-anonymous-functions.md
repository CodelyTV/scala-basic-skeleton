#Functions and lambdas

Finally, we arrived to the most important and the most difficult part of this 
chapter.

In Scala, functions could receive another functions with their parameters and
their return values. Let's checkout this.

```scala
def sum(value: Int): Int = value + 1

def changeValues(list: List[Int]): List[Int] = list.map(sum)

val list: List[Int] = List(1, 2, 3, 4, 5)

changeValues(list) // List(2, 3, 4, 5, 6)
```

In this case, `map` is iterating over list and applying `sum` function to each element.

In simpler words, `map` is expecting a function that receives an `Int` and returns
another type. In this case, due to `changeValues` expects to return a list of `List[Int]`,
`map` is looking for a function that receives an `Int` and returns another `Int`.
That is our function `sum`!
