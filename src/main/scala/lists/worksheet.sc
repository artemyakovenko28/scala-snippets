import scala.annotation.tailrec

val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: 2 :: 3 :: 4 :: Nil
val diag3 = (1 :: (0 :: (0 :: Nil))) ::
  (0 :: (1 :: (0 :: Nil))) ::
  (0 :: (0 :: (1 :: Nil))) :: Nil
val empty = Nil

val List(x, y, z@_*) = nums
val a :: b :: rest = nums

List(1, 2) ::: List(3, 4, 5)
List(3, 4, 5).:::(List(1, 2))

Nil ::: List(1, 2, 3)
List(1, 2, 3) ::: List(4)

def concatenate[T](xs: List[T], ys: List[T]): List[T] =
  xs match {
    case Nil => ys
    case x :: xs1 => x :: concatenate(xs1, ys)
  }

concatenate(List(1, 2, 3), List(4, 5, 6))

val list = List(1, 2, 3, 4, 5)
list.head // O(1)
list.tail // O(1)
list.length // O(n)
list.last // O(n)
list.init // O(n)
list.reverse // O(n)
list.take(3)
list.drop(3)
assert(list.splitAt(3) == (list.take(3), list.drop(3)))
list.apply(2) // O(n) rare in Scala
list(2) // O(n) rare in Scala
list.indices

List(List(1, 2), List(), List(3), List(4, 5), List(6, 7, 8)).flatten
fruits.flatMap(_.toCharArray)

val letters = List("a", "b", "c", "d")
letters.zip(letters.indices)
letters.zip(List(1, 2, 3)) // unmatched elements are dropped - "d"
letters.zipWithIndex

List(("a", 1), ("b", 2), ("c", 3)).unzip

letters.toString
list.toString

list.mkString(",")
list.mkString("", ",", "")
list.mkString("[", ",", "]")
list.mkString

val builder = new StringBuilder
list.addString(builder, "(", ";", ")")

val array = list.toArray
array.toList

val arr = new Array[Int](10)
list.copyToArray(arr, 3)
arr

val it = list.iterator
it.next
it.next

// O(n^2) implementation
def reverse[T](xs: List[T]): List[T] = xs match {
  case Nil => xs
  case x :: xs1 => reverse(xs1) ::: List(x)
}

reverse(List("a", "b", "c", "d"))


def mSort(xs: List[Int]): List[Int] = {
  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (_, Nil) => xs
    case (Nil, _) => ys
    case (x :: xs1, y :: ys1) =>
      if (x < y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
  }

  xs match {
    case xs1@(Nil | List(_)) => xs1
    case _ =>
      val (a, b) = xs.splitAt(xs.length / 2)
      merge(mSort(a), mSort(b))
  }
}

mSort(List(3, 4, 7, 3, 8, 5, 4, 3))

// higher-order methods on class list
val words = List("the", "quick", "brown", "fox")
words.map(_.length)
words.map(_.toList.reverse.mkString)
words.flatMap(_.toList)
list.filter(_ % 2 == 0)
words.filter(_.length == 3)

// xs partition p equals (xs filter p, xs filter (!p(_)))
list.partition(_ % 2 == 0)
assert(list.find(_ % 2 == 0).contains(2))
assert(list.find(_ % 2 < 0) == None)
List(1, 2, 3, -4, 5).takeWhile(_ > 0)
words.dropWhile(_.startsWith("t"))

// xs span p equals (xs takeWhile p, xs dropWhile p)
List(1, 2, 3, -4, 5).span(_ > 0)
list.forall(_ > 0)
List(1, 2, 3, -4, 5).exists(_ < 0)

// fold left
list.sum
list.foldLeft(0)(_ + _)

list.product
list.foldLeft(1)(_ * _)

words.foldLeft("")(_ + " " + _)

def reverseLeft[T](xs: List[T]): List[T] = {
  xs.foldLeft(List[T]())((ys, y) => y :: ys)
}

reverseLeft(List(1, 2, 3, 4))

List(1, -3, 4, 2, 6).sortWith(_ < _)
words.sortWith(_.length > _.length)

// Methods of the List companion object
List(1, 2, 3) == List.apply(1, 2, 3)

List.range(1, 5)
List.range(1, 9, 2)
List.range(9, 1, -3)

List.fill(5)('a')
List.fill(5, 2)("hello")

List.tabulate(5)(n => n * n)
List.tabulate(10, 10)(_ * _).mkString("\n")

List.concat(List("a", "b", "c"), List("d", "e"), List(), List("f"))

List(10, 20).lazyZip(List(3, 4, 5)).map(_ * _)
List("abc", "de").lazyZip(List(3, 2)).forall(_.length == _)
List("abc", "de").lazyZip(List(3, 2)).exists(_.length != _)