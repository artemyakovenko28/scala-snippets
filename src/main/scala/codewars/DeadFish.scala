package com.company
package codewars

// i increments the value (initially 0)
// d decrements the value
// s squares the value
// o outputs the value into the return array
object DeadFish {

  def parse(data: String): List[Int] = {
    var output = List.empty[Int]
    var res = 0
    output = output :+ res
    for (ch <- data) {
      ch match {
        case 'i' => res += 1
        case 'd' => res -= 1
        case 's' => res = res * res
        case 'o' => output = res :: output
      }
    }
    output.reverse
  }

  def main(args: Array[String]): Unit = {
    assert(DeadFish.parse("iiisdoso") == List(8, 64))
    assert(DeadFish.parse("iiisdosodddddiso") == List(8, 64, 3600))
  }
}
