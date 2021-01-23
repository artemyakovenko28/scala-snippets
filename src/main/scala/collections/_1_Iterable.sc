// Iterable methods
val xs = Iterable(1, 2, 3, 4, 5)

// abstact method
xs.iterator

// other iterators
val git = xs.grouped(3)
git.next()
git.next()

val sit = xs.sliding(3)
sit.next()
sit.next()
sit.next()

// sub collections
xs.takeRight(3)
xs.dropRight(2)

// zippers
xs.zip(Iterable("a", "b", "c", "d"))
xs.zipAll(Iterable("a", "b"), 2.5, "d")
xs.zipWithIndex

// comparison
xs.iterator.sameElements(Iterable(1, 2, 3, 4, 5)) // xs.sameElements(1, 2, 3, 4, 5)
