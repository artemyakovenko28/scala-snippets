package com.company
package codewars

class SplitStrings {

  def solution(s: String): List[String] = {
    s.grouped(2).map(v => {
      if (v.length == 2) v
      else v + "_"
    }).toList
  }
}

object SplitStrings {
  def main(args: Array[String]): Unit = {
    val s = new SplitStrings
    println(s.solution("abc"))
    println(s.solution("abcdef"))
  }
}
