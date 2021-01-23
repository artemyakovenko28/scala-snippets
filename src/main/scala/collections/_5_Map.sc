import scala.collection.mutable

// Map methods
val ms = Map("apple" -> 2, "orange" -> 3, "banana" -> 2)

// lookups
ms.get("apple")
ms("apple")
ms.getOrElse("notExisting", "default")
ms.contains("apple")
ms.isDefinedAt("apple") // same as contains

// additions and updates
ms + ("potato" -> 1)
ms ++ Iterable("potato" -> 1, "peach" -> 3) // ms + ("potato" -> 1, "peach" -> 3)
ms.updated("apple", 100) // same as ms + (k -> v)

// removals
ms - "apple"
ms -- Iterable("apple", "orange") // ms - ("apple", "orange")

// sub collections
ms.keys
ms.keySet
ms.keysIterator
ms.values
ms.valuesIterator

// transformation
ms.view.filterKeys(_.startsWith("b")) // ms.filterKeys(_.startsWith("b"))
ms.view.mapValues(_ + 10)

// --------------------------------------------
// mutable.Map methods
val zs = mutable.Map("apple" -> 2, "orange" -> 3, "banana" -> 2)

// additions and updates
zs.update("apple", 10)
zs += ("peach" -> 10)
zs ++= Iterable("peach" -> 10, "lemon" -> 20) // zs += ("peach" -> 10, "lemon" -> 20)
zs.put("apple", 50)
zs.getOrElseUpdate("pineapple", 10)
zs -= "apple"
zs --= Iterable("orange", "banana") // zs -= ("orange", "banana")
zs.remove("lemon")
zs.filterInPlace((_ ,v) => v > 10) // zs.retain((_ ,v) => v > 10)
zs.clear()

// transformation and cloning
zs ++ Iterable("apple" -> 2, "orange" -> 3, "banana" -> 2)
zs.mapValuesInPlace((_, v) => v * 10) // zs.transform((_, v) => v * 10)
val zs1 = zs.clone()
zs1 == zs