package codewars
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SqureArraysTest extends AnyFlatSpec with Matchers {
  val tests = List(
    (Array(1, 2, 3),       Array(4, 5, 6),         9.0),
    (Array(10, 20, 10, 2), Array(10, 25, 5, -2),  16.5),
    (Array(0, -1),         Array(-1, 0),           1.0)
  )
  tests.foreach {
    case (input1, input2, expected) =>
      s"solution(${input1.mkString(", ")}), (${input2.mkString(", ")})" should s"return $expected" in {
        SqureArrays.solution(input1, input2) should be (expected)
      }
  }
} 