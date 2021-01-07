import com.company.traits.{BasicIntQueue, Frog, Philosophical, Point, Rectangle}

val frog = new Frog
frog.philosophize()

val phil: Philosophical = frog
phil.philosophize()

val phog: Philosophical = new Frog
phog.philosophize()

//--------------------------------------------

val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
rect.left
rect.right
rect.width
