package com.company
package codewars

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DupsTest extends AnyFlatSpec with Matchers {

  "duplicateCount(\"abcde\")" should "return 0" in {
    Dups.duplicateCount("abcde") should be (0)
  }

  "duplicateCount(\"abcdea\")" should "return 1" in {
    Dups.duplicateCount("abcdea") should be (1)
  }

  "duplicateCount(\"indivisibility\")" should "return 1" in {
    Dups.duplicateCount("indivisibility") should be (1)
  }

  "duplicateCount(\"abcdeaB\")" should "return 1" in {
    Dups.duplicateCount("indivisibility") should be (1)
  }
}
