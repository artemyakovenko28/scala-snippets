import scala.annotation.Annotation

class strategy(arg: Annotation) extends Annotation

class delayed extends Annotation

@strategy(new delayed)
def f(): Unit = {}

@deprecated("use newShinyMethod() instead")
def bigMistake(): Unit = {}

// @deprecated
// @volatile
// @serializable
// @SerialVersionUID(1234)
// @BeanProperty
// @tailrec
// @unchecked