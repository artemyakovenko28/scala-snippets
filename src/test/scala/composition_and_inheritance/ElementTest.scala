package com.company
package composition_and_inheritance

import composition_and_inheritance.Element.elem

import org.scalatest.funsuite.AnyFunSuite

class ElementTest extends AnyFunSuite {

  test("elem result should have passed width") {
    val e = elem('x', 2, 3)
    assert(e.width == 2)
  }
}
