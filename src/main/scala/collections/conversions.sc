import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

val jul: java.util.List[Int] = ArrayBuffer(1, 2, 3).asJava
val buf: Seq[Int] = jul.asScala