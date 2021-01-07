package com.company
package composition_and_inheritance

import composition_and_inheritance.Element.elem

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ElementSpec extends AnyFlatSpec with Matchers {

  "a UniformElement" should "have a width equal to the passed value" in {
    val e = elem('x', 2, 3)
    e.width should be(2)
  }

  it should "have a height equal to the passed value" in {
    val e = elem('x', 2, 3)
    e.height should be(3)
  }

  it should "throw an illegal argument exception if passed a negative width" in {
    an [IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }
}
