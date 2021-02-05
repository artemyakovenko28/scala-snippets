package com.company
package modular_programming

object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes {

  private val categories: List[FoodCategory] = List(
    FoodCategory("fruits", List(Apple, Orange)),
    FoodCategory("misc", List(Cream, Sugar))
  )

  def allCategories: List[FoodCategory] = categories
}
