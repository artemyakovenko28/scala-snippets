package com.company

class ImmutableMap {

  def main(args: Array[String]): Unit = {
    val treasureMap = Map(
      1 -> "Go to island.",
      2 -> "Find big X on groud.",
      13 -> "Dig",
    )
    println(treasureMap(2))
  }
}
