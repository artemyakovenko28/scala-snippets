package com.company
package xml

import scala.xml.{Elem, Node}

abstract class CCTerm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int
  val purchasePrice: Int
  val condition: Int

  def toXML: Elem =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>

  override def toString: String = description
}

object CCTerm {

  def fromXml(node: Node): CCTerm =
    new CCTerm {
      val description: String = (node \ "description").text
      val yearMade: Int = (node \ "yearMade").text.toInt
      val dateObtained: String = (node \ "dateObtained").text
      val bookPrice: Int = (node \ "bookPrice").text.toInt
      val purchasePrice: Int = (node \ "purchasePrice").text.toInt
      val condition: Int = (node \ "condition").text.toInt
    }
}
