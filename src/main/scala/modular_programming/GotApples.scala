package com.company
package modular_programming

object GotApples {

  def main(args: Array[String]): Unit = {
    require(args.nonEmpty)

    val db = if (args(0) == "student") StudentDatabase else SimpleDatabase

    object browser extends Browser {
      override val database: db.type = db
    }

    val apple = SimpleDatabase.foodNamed("Apple").get

    for (recipe <- browser.recipesUsing(apple))
      println(recipe)
  }
}
