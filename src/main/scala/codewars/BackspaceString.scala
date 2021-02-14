package com.company
package codewars

object BackspaceString {
  def cleanString(s: String): String = {
    val res = new StringBuilder
    for (ch <- s) {
      ch match {
        case '#' => if (res.nonEmpty) res.deleteCharAt(res.length() - 1)
        case _ => res += ch
      }
    }
    res.toString()
  }
}
