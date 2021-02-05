import com.company.object_equality.{Color, ColoredPoint, MutablePoint, Point}

import scala.collection.mutable

val p1, p2 = new Point(1, 2)

val q = new Point(2, 3)

p1 equals p2
p1 equals q

val coll = mutable.HashSet(p1)
coll contains p2
coll contains p1

//-----------------------------------------

val mp = new MutablePoint(1, 2)
val c = mutable.HashSet(mp)

c.contains(mp)
mp.x += 1
c.contains(mp)

//----------------------------------------
// symmetric
val p = new Point(1, 2)
val cp = new ColoredPoint(1, 2, Color.Red)

p.equals(cp)
cp.equals(p)

// transitive
val redp = new ColoredPoint(1, 2, Color.Red)
val bluep = new ColoredPoint(1, 2, Color.Blue)

redp == p
p == bluep
redp == bluep

val pAnon = new Point(1, 1) { override val y = 2 }

val l = List(p)
coll.contains(p)
coll.contains(cp)
coll.contains(pAnon)
