package com.company
package modular_programming

trait SimpleFoods {

  object Apple extends Food("Apple")

  object Orange extends Food("Orange")

  object Cream extends Food("Cream")

  object Sugar extends Food("Sugar")

  def allFoods: List[Food] =
    List(Apple, Orange, Cream, Sugar)
}