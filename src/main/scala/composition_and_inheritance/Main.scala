package com.company
package composition_and_inheritance

import composition_and_inheritance.Element.elem

object Main {
  def main(args: Array[String]): Unit = {
    val element = elem(Array("hello", "world"))
    println("width = " + element.width)
    println("height = " + element.height)

    val e1: Element = elem(Array("hello", "world"))
    val ae: Element = elem("hello")
    val e2: Element = ae
    val e3: Element = elem('x', 2, 3)
  }
}
