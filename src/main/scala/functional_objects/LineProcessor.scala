package com.company
package functional_objects

import java.io.File

object LineProcessor {
  def main(args: Array[String]): Unit = {
    for (file <- new File(".").listFiles()) {
      println(file)
    }
  }
}