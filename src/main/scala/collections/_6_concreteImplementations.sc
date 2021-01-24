import scala.collection.immutable.{ListMap, Queue}
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

// LazyList (Stream)
val str = 1 #:: 2 #:: 3 #:: LazyList.empty

def fibFrom(a: Int, b: Int): LazyList[Int] =
  a #:: fibFrom(b, a + b)

val fibs = fibFrom(1, 1).take(7)
fibs.toList

// Vector
val vec = Vector.empty
val vec2 = vec :+ 1 :+ 2
val vec3 = 100 +: vec2
vec3(0)
IndexedSeq(1, 2, 3)

// Stack
val stack = mutable.Stack.empty[Int]
val hasOne = stack.push(1)
hasOne.top
hasOne.pop()

// Queue
val queue = Queue.empty[Int]
val has1 = queue.enqueue(1)
val has123 = has1.enqueueAll(List(2, 3))
val (element, has12) = has123.dequeue

// Range
1 to 3
5 to 14 by 3
1 until 3

// ListMap
val builder = ListMap.newBuilder[String, Int]
builder += ("one" -> 1)
builder += ("two" -> 2)
val lms = builder.result()
lms("two")

// ArrayBuffer
val buf = ArrayBuffer.empty[Int]
buf += 1
buf += 10
buf.toArray

// ListBuffer
val lBuf = ListBuffer.empty[Int]
lBuf += 1
lBuf += 10
buf.toArray

// StringBuilder
val sb = new StringBuilder
sb += 'a'
sb ++= "bcde"
sb.toString()

// Array
val a1 = Array(1, 2, 3)
val a2 = a1.map(_ * 3)
val a3 = a2.filter(_ % 2 != 0)
a3.reverse

val seq: Seq[Int] = a1
val a4 = seq.toArray
a1 eq a4