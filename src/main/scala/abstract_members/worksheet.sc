import com.company.abstract_members.{LazyRationalTrait, RationalTrait}

abstract class Fruit {
  val v: String

  def m: String
}

abstract class Apple extends Fruit {
  val v: String
  val m: String
}

new {
  val numerArg: Int = 1
  val denomArg: Int = 2
} with RationalTrait

object twoThirds extends {
  override val numerArg = 2
  override val denomArg = 3
} with RationalTrait

twoThirds

class RationalClass(n: Int, d: Int) extends {
  override val numerArg = n
  override val denomArg = d
} with RationalTrait {
  def +(that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}

object Demo {
  val x = {
    println("initializing x")
    "done"
  }
}

object LazyDemo {
  lazy val x = {
    println("initializing x")
    "done"
  }
}

Demo
Demo.x

LazyDemo
LazyDemo.x

new LazyRationalTrait {
  val numerArg: Int = 2
  val denomArg: Int = 4
}