package com.company
package extractors

object ExpandedEmail {

  def unapplySeq(email: String): Option[(String, Seq[String])] = {
    val parts = email.split("@")
    if (parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else None
  }
}
