package com.company
package object_equality

class MutablePoint(var x: Int, var y: Int) {
  override def hashCode(): Int = (x, y).##

  override def equals(obj: Any): Boolean = obj match {
    case that: Point => x == that.x && y == that.y
    case _ => false
  }
}
