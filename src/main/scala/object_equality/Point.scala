package com.company
package object_equality

class Point(val x: Int, val y: Int) {

  override def hashCode(): Int = (x, y).##

  def canEqual(other: Any): Boolean = other.isInstanceOf[Point]

  override def equals(obj: Any): Boolean = obj match {
    case that: Point =>
      that.canEqual(this) &&
        (this.x == that.x) && (this.y == that.y)
    case _ => false
  }
}
