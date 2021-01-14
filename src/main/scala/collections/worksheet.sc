import scala.collection.immutable.{TreeMap, TreeSet}
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

// List
val colors = List("red", "blue", "green")
colors.head
colors.tail

// Array
val fiveInts = new Array[Int](5)
val fiveToOne = Array(5, 4, 3, 2, 1)
fiveInts(0) = fiveToOne(4)
fiveInts

// ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
3 +=: buf
buf
buf.toList

// ArrayBuffer
val arrayBuf = new ArrayBuffer[Int]()
arrayBuf += 12
arrayBuf += 15
5 +=: arrayBuf
arrayBuf(2)
arrayBuf.length

// String via implicit conversion to StringOps
def hasUpperCase(s: String): Boolean = s.exists(_.isUpper)
hasUpperCase("Robert Frost")
hasUpperCase("e e  cummings")

// Set
mutable.Set(1, 2, 3)
val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
val words = mutable.Set.empty[String]
for (word <- wordsArray)
  words += word.toLowerCase
words

// immutable set
val nums = Set(1, 2, 3)
nums + 5
nums - 3
nums ++ List(5, 6)
nums -- List(1, 2)
nums & Set(1, 3, 5, 7)
nums.size
nums.contains(3)

// mutable set
words += "the"
words -= "the"
words ++= List("do", "re", "mi")
words --= List("do", "re")
words.clear()

val mutableMap = mutable.Map.empty[String, Int]
mutableMap += "hello" -> 1
mutableMap += "there" -> 2
mutableMap
mutableMap("hello")

def countWords(text: String): mutable.Map[String, Int] = {
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ !,.]+")) {
    val word = rawWord.toLowerCase
    val oldCount = if (counts.contains(word)) counts(word) else 0
    counts += word -> (oldCount + 1)
  }
  counts
}

countWords("See Spot run! Run, Spot. Run!")

// common map methods (both immutable and mutable)
val numbers = Map("i" -> 1, "ii" -> 2)
numbers + ("vi" -> 6)
numbers - "ii"
numbers ++ List("iii" -> 3, "iv" -> 4)
numbers -- List("i", "ii")
numbers.size
numbers.contains("ii")
numbers("ii")
numbers.keys
numbers.keySet
numbers.values
numbers.isEmpty
mutableMap += "one" -> 1
mutableMap -= "one"
mutableMap ++= List("one" -> 1, "two" -> 2, "three" -> 3)
mutableMap --= List("one", "two")

// sorted sets and maps
val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
val cs = TreeSet('f', 'u', 'n')
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm += (2 -> 'x')

// initializing collections
val colorsList = List("blue", "yellow", "red", "green")
val colorsSet = TreeSet[String]() ++ colorsList
colorsSet.toList
colorsSet.toArray

val mutableSet = mutable.Set.empty ++= colorsSet
val immutableSet = Set.empty ++ mutableSet
val mutaMap = mutable.Map("i" -> 1, "ii" -> 2)
val immutableMap = Map.empty ++ mutaMap

// Tuples
def longestWord(words: Array[String]): (String, Int) =
  words.zipWithIndex.maxBy(_._1.length)

val longest = longestWord("The quick brown fox".split(" "))
longest._1
longest._2
val (word, index) = longest
val tupleOne, tupleTwo = longest
