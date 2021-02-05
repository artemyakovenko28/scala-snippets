package com.company
package modular_programming

trait SimpleRecipes {
  this: SimpleFoods =>

  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Orange, Cream, Sugar),
    "Stir it all together"
  )

  def allRecipes: List[Recipe] =
    List(FruitSalad)
}
