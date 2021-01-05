package com.company
package fuctions_and_closures.lines

import scala.io.Source

object LongLines {
  def processFile(fileName: String, width: Int): Unit = {

    def processLine(line: String): Unit = {
      if (line.length > width) {
        println(s"$fileName: ${line.trim}")
      }
    }

    println(System.getProperty("user.dir"))
    val source = Source.fromFile(fileName)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }

  def main(args: Array[String]): Unit = {
    val fileName = "src/main/scala/functional_objects/LineProcessor.scala"
    val width = 20
    processFile(fileName, width)
  }
}
