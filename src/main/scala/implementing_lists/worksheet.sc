val xs = List(1, 2, 3)
val ys: List[Any] = xs

class Fruit
class Apple extends Fruit
class Orange extends Fruit

val apples = new Apple :: Nil
val fruits = new Orange :: apples
