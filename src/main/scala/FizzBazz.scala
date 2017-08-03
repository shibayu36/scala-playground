object FizzBazz {
  def main(args: Array[String]): Unit = {
    for (i <- 0 to 30) {
      println(getFizzBazzString(i))
    }
  }

  def getFizzBazzString(i: Int): String = {
    if (i % 3 == 0 && i % 5 == 0) {
      return "FizzBuzz"
    } else if (i % 3 == 0) {
      return "Fizz"
    } else if (i % 5 == 0) {
      return "Buzz"
    } else {
      return i.toString
    }
  }
}
