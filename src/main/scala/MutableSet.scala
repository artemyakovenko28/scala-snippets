package com.company

import scala.collection.mutable

object MutableSet {

  def main(args: Array[String]): Unit = {
    val jetSet = mutable.Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet)
  }
}
