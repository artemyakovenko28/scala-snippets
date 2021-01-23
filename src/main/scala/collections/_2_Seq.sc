// Seq methods
val xs = Seq(1, 2, 3, 4, 5, 5, 5)

// indexing and length
xs(1) // xs.apply(1)
xs.isDefinedAt(10)
xs.length // xs.size
xs.lengthCompare(Iterable(1, 2, 3, 4, 5))
xs.indices

// index search
xs.indexOf(5)
xs.lastIndexOf(5)
xs.indexOfSlice(Seq(3, 4, 5))
xs.lastIndexOfSlice(Seq(3, 4, 5))
xs.indexWhere(_ % 2 == 0)
xs.segmentLength(_ != 5)

// additions
-1 +: xs
xs :+ -6
xs.padTo(15, 7)

// updates
xs.patch(0, Iterable(8, 8, 8), 2)
xs.updated(1, 10)

// sorting
xs.sorted
xs.sortWith(_ > _)
xs.sortBy(_ % 2)

// reversals
xs.reverse
xs.reverseIterator
xs.reverseIterator.map(_ + 10).to(Seq) // xs.reverseMap()

// comparisons
xs.startsWith(Iterable(1, 2, 3))
xs.endsWith(Iterable(4, 5, 5, 5))
xs.contains(5)
xs.containsSlice(Seq(3, 4, 5))
xs.corresponds(
  Iterable(11, 12, 13, 14, 15, 15, 15))(_ + 10 == _)

// multiset operations
xs.intersect(Seq(5, 4, 3))
xs.diff(Seq(5, 4, 3))
xs.concat(Iterable(5, 4, 3)) // xs.union(Seq(5, 4, 3))
xs.distinct
xs.distinctBy(_ % 2)