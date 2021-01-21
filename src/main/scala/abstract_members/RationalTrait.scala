package com.company
package abstract_members

import scala.annotation.tailrec

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)

  private val g = gcd(numerArg, denomArg)

  val numer: Int = numerArg / g
  val denom: Int = denomArg / g

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String = numer + "/" + denom
}
