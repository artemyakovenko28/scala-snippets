import com.company.xml.CCTerm

import scala.xml.{Elem, NodeSeq, XML}

<a>
  This is some xml.
  Here is a tag:
  <atag/>
</a>

  <a>
    {"hello" + "world"}
  </a>

val yearMade = 1955

<a>
  {if (yearMade < 2000)
  <old>
    {yearMade}
  </old>
else NodeSeq.Empty}
</a>

  <a>
    {3 + 4}
  </a>

  // xss injection preventing
  <a>
    {"</a>potential security hole<a>"}
  </a>

"<a>" + "</a>potential security hole<a>" + "</a>"

<a>{{brace yourself!}}</a>

// serialization
val therm = new CCTerm {
  val description = "hot dog #5"
  val yearMade = 1952
  val dateObtained = "March 14, 2006"
  val bookPrice = 2199
  val purchasePrice = 500
  val condition = 9
}

therm.toXML

// taking XML apart
// extracting text
<a>Sounds <tag/> good</a>.text
<a> input ---&gt; output </a>.text
// extracting sub-elements
<a><b><c>hello</c></b></a> \ "b"
<a><b><c>hello</c></b></a> \ "c"
<a><b><c>hello</c></b></a> \\ "c" // deep search
<a><b><c>hello</c></b></a> \ "a"
<a><b><c>hello</c></b></a> \\ "a"
// extracting attributes
val joe = <employee
  name="Joe"
  rank="code monkey"
  serial="123"/>

joe \ "@name"
joe \ "@serial"

// deserialization
val node = <cctherm>
  <description>hot dog #5</description>
  <yearMade>1952</yearMade>
  <dateObtained>March 14, 2006</dateObtained>
  <bookPrice>2199</bookPrice>
  <purchasePrice>500</purchasePrice>
  <condition>9</condition>
</cctherm>

CCTerm.fromXml(node)

// loading and saving
XML.save("therm1.xml", node)
XML.loadFile("therm1.xml")

// pattern matching
def proc(node: scala.xml.Node): String =
  node match {
    case <a>{contents}</a> => "It's an a: " + contents
    case <b>{contents}</b> => "It's a b: " + contents
    case _ => "It's something else."
  }

proc(<a>apple</a>)
proc(<b>banana</b>)
proc(<c>cherry</c>)

proc(<a>a <em>red</em> apple</a>)
proc(<a/>)

def procSub(node: scala.xml.Node): String =
  node match {
    case <a>{contents @ _*}</a> => "It's an a: " + contents
    case <b>{contents @ _*}</b> => "It's a b: " + contents
    case _ => "It's something else."
  }

procSub(<a>a <em>red</em> apple</a>)
procSub(<a/>)
