package com.company
package composition_and_inheritance

import composition_and_inheritance.Element.elem

import org.specs2.mutable.Specification

object ElementSpecification extends Specification {

  "A UniformElement" should {
    "have a width equal to the passed value" in {
      val e = elem('x', 2, 3)
      e.width must be_==(2)
    }
    "have a height equal to the passed value" in {
      val e = elem('x', 2, 3)
      e.height must be_==(3)
    }
    "throw an IAE if passed a negative width" in {
      elem('x', -2, 3) must throwA[IllegalArgumentException]
    }
  }
}
