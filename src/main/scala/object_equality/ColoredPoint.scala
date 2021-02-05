package com.company
package object_equality

class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends Point(x, y) {

  override def canEqual(other: Any): Boolean = other.isInstanceOf[ColoredPoint]

  override def equals(obj: Any): Boolean = obj match {
    case that: ColoredPoint => that.canEqual(this) &&
      this.color == that.color && super.equals(that)
    case _ => false
  }
}
