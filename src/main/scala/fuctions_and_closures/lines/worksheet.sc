println("hello" indexOf 'o')
println("hello world" indexOf ('o', 5))
-2.0
2.0.unary_-

println()
import scala.language.postfixOps
"Hello World" toLowerCase

// object equality
assert(List(1, 2, 3) == List(1, 2, 3))
assert(List(1, 2, 3) != List(4, 5, 6))

// partially applied functions
def sum(a: Int, b: Int, c: Int): Int = a + b + c
val a = sum _
val b = sum(2, _: Int, 4)
a(1, 2, 3)
b(4)

//closures
var more = 1
val addMore = (x: Int) => x + more
addMore(3)
more = 10
addMore(10)

val someNumbers = List(-11, -10, -5, 0, 5, 10)
var sum = 0
someNumbers.foreach(sum += _)
sum

def makeIncreaser(more: Int) =
  (x: Int) => x + more

val inc1 = makeIncreaser(1)
val inc20 = makeIncreaser(20)

inc1(5)
inc20(5)

//repeated parameters
def echo(args: String*): Unit =
  for (arg <- args)
    println(arg)

echo()
echo("one")
echo("hello", "world!")
val arr = Array("array", "list", "of", "parameters")
echo(arr: _*)

//named arguments
def speed(distance: Float, time: Float): Float =
  distance / time

speed(100, 10)
speed(distance = 100, time = 10)
speed(time = 10, distance = 100)


//currying
def curriedSum(a: Int)(b: Int): Int = a + b

curriedSum(4)(5)
val fourPlus = curriedSum(4)_
fourPlus(5)
