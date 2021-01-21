import com.company.abstract_members.US

class Food

abstract class Animal {
  type SuitableFood <: Food

  def eat(food: SuitableFood): Unit
}

class Grass extends Food

class Cow extends Animal {
  type SuitableFood = Grass

  override def eat(food: Grass): Unit = {}
}

val bessy = new Cow
bessy.eat(new Grass)

class DogFood extends Food

class Dog extends Animal {
  type SuitableFood = DogFood

  override def eat(food: DogFood): Unit = {}
}

val lassie = new Dog
lassie.eat(new lassie.SuitableFood)

val bootsie = new Dog
bootsie.eat(new bootsie.SuitableFood)
bootsie.eat(new lassie.SuitableFood)

// Path dependent types
class Outer {

  class Inner

}

val o1 = new Outer
val o2 = new Outer
new o1.Inner

// Refinement types
class Pasture {
  var animals: List[Animal {type SuitableFood = Grass}] = Nil
}

// Enumerations
object Color extends Enumeration {
  val Red, Green, Blue = Value
}

object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}

for (d <- Direction.values)
  print(s"$d ")

Direction.East.id
Direction(1)
