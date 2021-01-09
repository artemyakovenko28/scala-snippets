import com.company.case_classes.{BinOp, Expr, Number, UnOp, Var}

val v = Var("x")
val op = BinOp("+", Number(1), v)

v.name
op.left
println(op)
op.right == Var("x")

op.copy(operator = "-")

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Number(0)) => e
  case BinOp("*", e, Number(1)) => e
  case _ => expr
}

simplifyTop(UnOp("-", UnOp("-", Var("x"))))

// wildcard patterns
BinOp("+", Var("x"), Number(1)) match {
  case BinOp(_, _, _) =>
    println("expression is a binary operation")
  case _ =>
}

// constant patterns
def describe(x: Any): String = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "empty list"
  case _ => "something else"
}

describe(5)
describe(true)
describe("hello")
describe(Nil)
describe(List(1, 2, 3))

// variable patterns
def findZero(x: Any) = x match {
  case 0 => "zero"
  case somethingElse => somethingElse
}
findZero(0)
findZero("arbitrary string")


// constructor patterns
BinOp("+", Var("x"), Number(1)) match {
  case BinOp("+", _, Number(1)) => println("a deep match")
  case _ =>
}

// sequence patterns
List(0, 1, 2) match {
  case List(0, _, _) =>
    println("list with length of 3 starts with 0")
  case _ =>
}

List(0, 1, 2, 3, 4, 5) match {
  case List(0, _*) =>
    println("list with arbitrary length starts with 0")
  case _ =>
}

// tuple patterns
(1, 2, 3) match {
  case (a, b, c) =>
    println(s"matches 3-th tuple with $a, $b, $c")
  case _ =>
}

// typed patterns
def generalSize(x: Any): Int = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}

assert(generalSize("abc") == 3)
assert(generalSize(Map("a" -> 1, "b" -> 2)) == 2)
assert(generalSize(math.Pi) == -1)

// type erasure in type parameters
def isIntMap(x: Any): Boolean = x match {
  case _: Map[Int, Int] => true
  case _ => false
}

isIntMap(Map(1 -> 1))
isIntMap(Map("abc" -> "abc"))

// no type erasure on arrays
def isStringArray(x: Any): Boolean = x match {
  case _: Array[String] => true
  case _ => false
}

isStringArray(Array("abc", "def"))
isStringArray(Array(1, 2, 3))

// variable binding
def simplifyAbs(expr: Expr): Expr = expr match {
  case UnOp("abs", e@UnOp("abs", _)) => e
  case _ => expr
}

simplifyAbs(UnOp("abs", UnOp("abs", Var("x"))))

// pattern guards
def simplifyAdd(expr: Expr): Expr = expr match {
  case BinOp("+", left, right) if left == right =>
    BinOp("*", Number(2), Var("x"))
  case _ => expr
}

simplifyAdd(BinOp("+", Var("x"), Var("x")))

// pattern overlaps
def simplifyAll(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) =>
    simplifyAll(e)
  case BinOp("+", e, Number(0)) =>
    simplifyAll(e)
  case BinOp("*", e, Number(1)) =>
    simplifyAll(e)
  case UnOp(op, e) =>
    UnOp(op, simplifyAll(e))
  case BinOp(op, l, r) =>
    BinOp(op, simplifyAll(l), simplifyAll(r))
  case _ => expr
}

// compiler helps with possible combinations
def describe(expr: Expr): String = (expr: @unchecked) match {
  case Number(_) => "a number"
  case Var(_) => "a variable"
}


// Option
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals get "France"
capitals get "North Pole"

def show(x: Option[String]): String = x match {
  case Some(s) => s
  case None => "?"
}

show(capitals get "Japan")
show(capitals get "France")
show(capitals get "North Pole")

// patterns in variable definitions
val tuple = (123, "abc")
val (number, string) = tuple

val exp = BinOp("*", Number(5), Number(1))
val BinOp(operator, left, right) = exp

// case sequences as partial functions
def withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

withDefault(Some(10))
withDefault(None)

val second: PartialFunction[List[Int], Int] = {
  case _ :: y :: _ => y
}

second.isDefinedAt(List(1, 2, 3))
second.isDefinedAt(List(1, 2))
second.isDefinedAt(Nil)

second(List(1, 2, 3))
second(List(1, 2))
second(List(1, 2, 3, 4, 5))

// patterns in for expressions
for ((country, city) <- capitals)
  println(s"The capital of $country is $city")

val fruits = List(Some("Apple"), None, Some("Orange"))

for (Some(fruit) <- fruits)
  println(fruit)