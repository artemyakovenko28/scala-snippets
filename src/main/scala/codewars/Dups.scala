package com.company
package codewars

object Dups {

  def duplicateCount(str: String): Int = {
    var letters = Map[Char, Int]()
    for (ch <- str) {
      val lower = ch.toLower
      letters.get(lower) match {
        case Some(value) => letters = letters + (lower -> (value + 1))
        case None => letters += (lower -> 1)
      }
    }
    letters.count(_._2 > 1)
  }
}
