import scala.collection.mutable

// Iterator
val i = Iterator("a", "number", "of", "words")
i.map(_.length).foreach(println)

val words = Iterator("a", "number", "of", "words")
words dropWhile (_.length < 2)
words.next()

// Iterator methods
val it = Iterator("a", "number", "of", "words")

// abstract methods
it.hasNext
it.next()

// variations
it.buffered
it.grouped(3)
it.sliding(3)

// copying
mutable.Buffer.empty ++ it // it.iterator.copyToBuffer(mutable.Buffer.empty)
it.copyToArray(Array.empty)

// duplication
it.duplicate

// additions
it ++ Iterator("hello", "world")
it.padTo(15, "initial")

// maps
it.map(_ + "abc")
it.flatMap(_ => Iterable("a", "b", "c"))
//it.collect()

// conversions
it.toArray
it.toList
it.toIterable // it.iterator.to(Iterable)
it.toSeq
it.toIndexedSeq
it.toStream
it.toSet
it.toMap

// size info
it.isEmpty
it.nonEmpty
it.size
it.length
it.hasDefiniteSize

// element retrieval index search
it.find(_.startsWith("p"))
