package com.company
package codewars

class ConsecutiveStrings {
  def longestConsec(strarr: Array[String], k: Int): String = {
//    if (strarr.length == 0 || strarr.length < k || k <= 0) ""
//    strarr.grouped(k)
    null
  }
}

object ConsecutiveStrings {
  def main(args: Array[String]): Unit = {
    val strarr = List("tree", "foling", "trashy", "blue", "abcdef", "uvwxyz")
    println(strarr.grouped(2).map(list => list.reduceLeft((a, b) => a + b)).toList)
  }
}
