package codewars

object DirReduction {

  def dirReduc(arr: Array[String]): Array[String] = {
    arr.reverse.foldRight(Array.empty[String]) {
      case ("SOUTH", a@Array("NORTH", _*)) => a.tail
      case ("NORTH", a@Array("SOUTH", _*)) => a.tail
      case ("EAST", a@Array("WEST", _*)) => a.tail
      case ("WEST", a@Array("EAST", _*)) => a.tail
      case (x, arr) => Array(x) ++ arr
    }.reverse
  }
}
