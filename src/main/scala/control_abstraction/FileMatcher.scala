package com.company
package control_abstraction

import java.io.File

object FileMatcher {
  def fileEnding(query: String): Array[File] = {
    fileMatching(_.endsWith(query))
  }

  def fileContaining(query: String): Array[File] = {
    fileMatching(_.contains(query))
  }

  def fileRegex(query: String): Array[File] = {
    fileMatching(_.matches(query))
  }

  private def fileMatching(matcher: String => Boolean): Array[File] = {
    for (file <- filesHere
         if matcher(file.getName)) yield file
  }

  private def filesHere: Array[File] = new File("src/main/scala/control_abstraction/").listFiles()

  def main(args: Array[String]): Unit = {
    println(fileEnding(".scala").mkString("Array(", ", ", ")"))
  }
}
