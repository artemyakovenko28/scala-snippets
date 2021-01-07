package com.company
package functional_objects

import scala.annotation.tailrec

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def +(i: Int): Rational = {
    new Rational(numer + i * denom, denom)
  }

  def -(that: Rational): Rational = {
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  }

  def -(i: Int): Rational = {
    new Rational(numer - i * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def *(i: Int): Rational = {
    new Rational(numer * i, denom)
  }

  def /(that: Rational): Rational = {
    new Rational(numer * that.denom, denom * that.numer)
  }

  def /(i: Int): Rational = {
    new Rational(numer, denom * i)
  }

  def lessThan(that: Rational): Boolean = {
    this.numer * that.denom < that.numer * this.denom
  }

  def max(that: Rational): Rational = {
    if (lessThan(that)) that else this
  }

  override def toString: String = {
    s"$numer/$denom"
  }

  @tailrec
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def compare(that: Rational): Int =
    (this.numer * that.denom) - (that.numer * this.denom)
}

object Rational {

  implicit def intToRational(i: Int): Rational = new Rational(i)

  def main(args: Array[String]): Unit = {
    val rational = new Rational(1, 2)
    println(rational)
    val sum = rational + new Rational(1, 3)
    println(s"sum = $sum")
    val notNormalized = new Rational(66, 42)
    println(s"normalization of not normalized: $notNormalized")
    val multiplied: Rational = rational * 2
    println("multiplied = " + multiplied)
    println(2 * multiplied)
  }
}