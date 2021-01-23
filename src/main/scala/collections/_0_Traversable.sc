import scala.collection.mutable.ListBuffer

// Traversable methods
val xs = Iterable(1, 2, 3)

// abstract method
xs.foreach(println)

// addition
xs ++ Iterable("x", "y", "z")

// maps
xs.map(_ + "a")
xs.flatMap(v => Iterable(v + "x", v + "y", v + "z"))
xs.collect {
  case e if e > 1 => e + e
}

// conversions
xs.toArray
xs.toList
xs.toIterable
xs.toSeq
xs.toIndexedSeq
xs.to(LazyList) // instead of xs.toStream
xs.toSet
//xs.toMap

// copying
ListBuffer.empty ++= xs // xs.copyToBuffer(ListBuffer.empty)
xs.copyToArray(Array.fill(3)(0))

// size info
xs.isEmpty
xs.nonEmpty
xs.size
xs.knownSize // xs.hasDefiniteSize

// element retrieval
xs.head
xs.headOption
xs.last
xs.lastOption
xs.find(_ == 2)

// sub collections
xs.tail
xs.init
xs.slice(1, 3)
xs.take(2)
xs.drop(2)
xs.takeWhile(_ < 2)
xs.dropWhile(_ > 2)
xs.filter(_ % 2 == 1)
xs.withFilter(_ % 2 == 1)
xs.filterNot(_ % 2 == 1)

// subdivisions
xs.splitAt(2)
xs.span(_ < 2)
xs.partition(_ % 2 == 0)
xs.groupBy(_ % 2 == 0)

// element conditions
xs.forall(_.isInstanceOf[Int])
xs.exists(_ % 2 == 0)
xs.count(_ > 1)

// folds
//(z /: xs)(op)
//(xs :\ z)(op)
//xs.foldLeft(z)(op)
//xs.foldRight(z)(op)
//xs reduceLeft op
//xs reduceRight op

// specific folds
xs.sum
xs.product
xs.min
xs.max

// strings
xs.addString(new StringBuilder)
xs.mkString(",")

// views
xs.view
xs.view.slice(1, 2) // xs.view(1, 2)