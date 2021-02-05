package com.company
package modular_programming

abstract class Database extends FoodCategories {

  def allFoods: List[Food]

  def foodNamed(name: String): Option[Food] =
    allFoods.find(_.name == name)

  def allRecipes: List[Recipe]
}
