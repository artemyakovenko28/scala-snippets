package com.company
package traits

class Animal

trait HasLegs

trait Philosophical {
  def philosophize(): Unit = {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"

  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}

object Frog {
  def main(args: Array[String]): Unit = {
    val phog: Philosophical = new Frog
    phog.philosophize()
  }
}
