package codewars

object HumanTime {

  val Second = 1
  val Minute: Int = 60 * Second
  val Hour: Int = 60 * Minute
  val Day: Int = 24 * Hour
  val Year: Int = 365 * Day

  def formatDuration(seconds: Int): String = {
    List(
      formatUnit(seconds % Year % Day % Hour % Minute / Second, "second"),
      formatUnit(seconds % Year % Day % Hour / Minute, "minute"),
      formatUnit(seconds % Year % Day / Hour, "hour"),
      formatUnit(seconds % Year / Day, "day"),
      formatUnit(seconds / Year, "year"),
    ).filter(_.nonEmpty) match {
      case Nil => "now"
      case x :: Nil => x
      case x :: xs => s"${xs.reverse.mkString(", ")} and $x"
    }
  }

  def formatUnit(value: Int, unit: String): String = {
    if (value == 0) ""
    else if (value == 1) s"$value $unit"
    else s"$value ${unit}s"
  }

  def main(args: Array[String]): Unit = {
    println(formatDuration(0))
    println(formatDuration(1))
    println(formatDuration(62))
    println(formatDuration(120))
    println(formatDuration(3600))
    println(formatDuration(3662))
  }
}
