import scala.collection.mutable

// Buffer methods
val buf = mutable.Buffer[Int]()

// additions
buf += 10
buf ++= Iterable(1, 1) // buff += (1, 1)
20 +=: buf
Iterable(2, 2) ++=: buf

buf.insert(0, 99)
buf.toString()

buf.insertAll(0, Iterable(55, 55))

// removals
buf -= 99
buf.remove(0)

buf.remove(0, 2)
buf.toString()

buf.dropInPlace(1) // buf.trimStart(1)
buf.dropRightInPlace(1) // buf.trimEnd(1)

buf.clear()
buf.toString()

// cloning
val b1 = mutable.Buffer(1,2,3)
val b2 = b1.clone()
b1 == b2

