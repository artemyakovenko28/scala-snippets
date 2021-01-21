package com.company
package abstract_members

import scala.annotation.tailrec

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int

  lazy val numer: Int = numerArg / g
  lazy val denom: Int = denomArg / g

  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String = numer + "/" + denom
}
