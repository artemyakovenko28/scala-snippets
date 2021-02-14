package com.company
package codewars

import org.scalatest.funsuite.AnyFunSuite

class BackspaceStringTest extends AnyFunSuite {
  test("Samples") {
    assert(BackspaceString.cleanString("abc#d##c")     === "ac")
    assert(BackspaceString.cleanString("abc####d##c#") === "" )
    assert(BackspaceString.cleanString("#######")      === "" )
    assert(BackspaceString.cleanString("")             === "" )
  }
}