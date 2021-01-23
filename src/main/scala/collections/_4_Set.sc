import scala.collection.mutable

val xs = Set("apple", "orange", "banana")

// Set methods
// tests
xs.contains("banana")
xs("banana")
xs.subsetOf(Set("apple", "orange", "banana", "potato"))

// additions
xs + "potato"
xs ++ Iterable("one", "two", "three") // xs + ("one", "two", "three")

// removals
xs - "orange"
xs -- Iterable("apple", "orange")
xs.empty

// binary operations
xs & Set("apple", "banana")
xs.intersect(Set("apple", "banana"))

xs | Set("apple", "potato")
xs.union(Set("apple", "potato"))

xs &~ Set("apple", "banana")
xs.diff(Set("apple", "banana"))

// ------------------------------------------
// mutable.Set methods
val ys = mutable.Set("apple", "potato", "peach", "tomato")

// additions
ys += "apple"
ys ++= Iterable("orange", "banana") // ys += ("orange", "banana")
ys.add("apple")

// removals
ys -= "apple"
ys --= Iterable("orange", "banana") // ys -= ("orange", "banana")
ys.remove("apple")
ys.filterInPlace(_.startsWith("p")) // ys.retain(_.startsWith("p"))
ys.clear()

// update
ys.update("apple", included = true)

// cloning
val ys1 = ys.clone()
ys == ys1