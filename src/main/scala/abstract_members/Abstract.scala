package com.company
package abstract_members

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
