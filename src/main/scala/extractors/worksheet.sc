import com.company.extractors._

def parseEmail(s: String): String = s match {
    case Email(user, domain) =>
      s"User '$user' has domain '$domain'"
    case _ => "This is not an email"
  }

println(parseEmail("example@gmail.com"))
println(parseEmail("hello world"))

def userTwiceUpper(s: String): String = s match {
  case Email(Twice(x @ UpperCase()), domain) =>
    "match: " + x + " in domain " + domain
  case _ => "no match"
}

userTwiceUpper("DIDI@hotmail.com")
userTwiceUpper("DIDO@hotmail.com")
userTwiceUpper("didi@hotmail.com")

def isTomInDotCom(s: String): Boolean = s match {
  case Email("tom", Domain("com", _*)) => true
  case _ => false
}

isTomInDotCom("tom@sun.com")
isTomInDotCom("peter@sun.com")
isTomInDotCom("tom@acm.org")

val ExpandedEmail(name, topdom, subdoms, _*) = "tom@support.epfl.ch"
name
topdom
subdoms

val Decimal = """(-)?(\d+)(\.\d*)?""".r
val input = "for -1.0 to 99 by 3"

for (s <- Decimal findAllIn input)
  println(s)
Decimal findFirstIn input
Decimal findPrefixOf input

val Decimal(sign, integerpart, decimalpart) = "-1.23"
val Decimal(a, b, c) = "1.0"


for (Decimal(s, i, d) <- Decimal findAllIn input)
  println(s"sign: $s, integer: $i, decimal: $d")