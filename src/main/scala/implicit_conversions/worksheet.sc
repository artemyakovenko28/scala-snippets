import com.company.functional_objects.Rational

// implicit conversion to an expected type
implicit def doubleToInt(x: Double): Int =
  x.toInt

val i: Int = 3.5

// converting the receiver
// 1. interoperating with new types
1 + new Rational(1, 2) ==
  Rational.intToRational(1) + new Rational(1, 2)
// 2. simulating new syntax (-> method)
Map("a" -> 1, "b" -> 2, "c" -> 3)

// 3. implicit classes
case class Rectangle(width: Int, height: Int)

implicit class RectangleMaker(width: Int) {
  def x(height: Int): Rectangle = Rectangle(width, height)
}

val rectangle = 10 x 20

// implicit parameters
class PreferredPrompt(val preference: String)

class PreferredDrink(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt,
                          drink: PreferredDrink): Unit = {
    println(s"Welcome, $name. The system is ready.")
    println(s"But while you work, why not enjoy a cup of ${drink.preference}?")
    println(prompt.preference)
  }
}

val bobsPrompt = new PreferredPrompt("relax> ")
val bobsDrink = new PreferredDrink("coffee")

Greeter.greet("Bob")(bobsPrompt, bobsDrink)

object JoesPrefs {
  implicit val prompt: PreferredPrompt =
    new PreferredPrompt("Yes, master> ")

  implicit val drink: PreferredDrink =
    new PreferredDrink("tea")
}

import JoesPrefs._

Greeter.greet("Joe")

def maxListOrdering[T](elements: List[T])
                      (ordering: Ordering[T]): T =
  elements match {
    case Nil => throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListOrdering(rest)(ordering)
      if (ordering.gt(x, maxRest)) x
      else maxRest
  }

def maxListImplicitParam[T](elements: List[T])
                           (implicit ordering: Ordering[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListImplicitParam(rest)(ordering)
      if (ordering.gt(x, maxRest)) x
      else maxRest
  }

maxListImplicitParam(List(1, 5, 10, 3))
maxListImplicitParam(List(1.5, 5.2, 10.7, 3.14159))
maxListImplicitParam(List("one", "two", "three"))

// context bounds
def maxList[T: Ordering](elements: List[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListImplicitParam(rest)
      if (implicitly[Ordering[T]].gt(x, maxRest)) x
      else maxRest
  }
