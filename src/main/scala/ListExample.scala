object ListExample {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6,7,8,9) // こういう感じでリスト作れる

    val sum = list.map { n => // 関数リテラル
      n * n
    }.filter { n =>
      n % 2 == 0
    }.sum
    println(sum);

    list.grouped(2).foreach { ns => println(ns) }

    val listMap = list.groupBy { n => if (n % 2 == 0) "even" else "odd" }
    println(listMap)

    val reduced = list.reduce { (x, y) => {
      x * 10 + y
    } }
    println(reduced)
  }
}
