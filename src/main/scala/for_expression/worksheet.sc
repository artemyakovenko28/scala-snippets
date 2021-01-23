case class Person(name: String,
                  isMale: Boolean,
                  children: Person*)

val lara = Person("Lara", isMale = false)
val bob = Person("Bob", isMale = true)
val julie = Person("Julie", false, lara, bob)
val persons = List(lara, bob, julie)

// query the names of all pairs of mothers and their children
persons.withFilter(!_.isMale)
  .flatMap(m => m.children
    .map(ch => (m.name, ch.name))
  )

for {
  p <- persons
  if !p.isMale
  ch <- p.children
} yield (p.name, ch.name)

for (x <- List(1, 2); y <- List("one", "two")) yield (x, y)

// querying with for expressions
case class Book(id: Int, title: String, authors: String*)

val books: List[Book] =
  List(
    Book(
      1,
      "Structure and Interpretation of Computer Programs",
      "Abelson, Harold", "Sussman, Gerald J."
    ),
    Book(
      2,
      "Principles of Compiler Design",
      "Aho, Alfred", "Ullman, Jeffrey"
    ),
    Book(
      3,
      "Programming in Modula-2",
      "Wirth, Niklaus"
    ),
    Book(
      4,
      "Elements of ML Programming",
      "Ullman, Jeffrey"
    ),
    Book(
      5,
      "The Java Language Specification", "Gosling, James",
      "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
    )
  )

for {
  b <- books
  a <- b.authors
  if a.startsWith("Gosling")
} yield b.title

for {
  b <- books
  if b.title.contains("Program")
} yield b.title

(for {
  b1 <- books
  b2 <- books
  if b1.title != b2.title
  a1 <- b1.authors
  a2 <- b2.authors
  if a1 == a2
} yield a1).distinct
