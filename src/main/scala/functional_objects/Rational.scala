package com.company
package functional_objects

class Rational(n: Int, d: Int) {

  override def toString: String = {
    s"$n/$d"
  }
}

object Rational {
  def main(args: Array[String]): Unit = {
    val rational = new Rational(1, 2)
    println(rational)
  }
}