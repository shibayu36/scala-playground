object OverloadExample {
  def main(args: Array[String]): Unit = {
    // println(Hoge.hoge("a")("i"))
    // println(Hoge.hoge("a")(1))

    println(Fuga.fuga(arg => arg * 2))
    println(Fuga.fuga((arg1, arg2) => arg1 + "-" + arg2))

    println(Piyo.piyo("piyo"))
    println(Piyo.piyo(a => a * 2))
  }

  object Hoge {
    def hoge(a: String)(b: String) = a + b
    def hoge(a: String)(b: Int) = a + (b * 2).toString
  }

  object Fuga {
    def fuga(a: String => String) = a("hoge") * 3
    def fuga(a: (String, String) => String) = a("hoge", "fuga") * 3
  }

  object Piyo {
    def piyo(a: => String): String = a * 3
    def piyo(a: String => String): String = a("piyo") * 3
  }
}
