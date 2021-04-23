package codewars

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HumanTimeTest extends AnyFlatSpec with Matchers {

  val tests = List(
    (1, "1 second"),
    (62, "1 minute and 2 seconds"),
    (120, "2 minutes"),
    (3600, "1 hour"),
    (3662, "1 hour, 1 minute and 2 seconds")
  )

  tests.foreach {
    case (input, expected) =>
      s"format($input)" should s"return $expected" in {
        HumanTime.formatDuration(input) should be (expected)
      }
  }
}

