package com.company

import scala.collection.mutable

object MutableMap {

  def main(args: Array[String]): Unit = {
    val treasureMap = mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on groud.")
    treasureMap += (2 -> "Dig")
  }
}
