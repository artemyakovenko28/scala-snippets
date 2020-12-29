package com.company

import scala.io.Source

object LineNumbers {
  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
      val maxWidth = getWidthOfLength(longestLine)
      for (line <- lines) {
        val padding = " " * (maxWidth - getWidthOfLength(line))
        println(s"$padding${line.length} | $line")
      }
    } else
      Console.err.println("Plese enter filename")
  }

  def getWidthOfLength(str: String): Int = str.length.toString.length
}
