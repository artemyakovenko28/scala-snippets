val v = Vector(1 to 10: _*)
val view = v.view
  .map(_ + 1)
  .map(_ + 2)

view.toSet
