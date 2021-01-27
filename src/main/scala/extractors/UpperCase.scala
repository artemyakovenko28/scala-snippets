package com.company
package extractors

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}
