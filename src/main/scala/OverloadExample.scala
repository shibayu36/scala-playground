object OverloadExample {
  def main(args: Array[String]): Unit = {
    // println(Hoge.hoge("a")("i"))
    // println(Hoge.hoge("a")(1))

    println(Fuga.fuga(arg => arg * 2))
    println(Fuga.fuga((arg1, arg2) => arg1 + "-" + arg2))
  }

  object Hoge {
    def hoge(a: String)(b: String) = a + b
    def hoge(a: String)(b: Int) = a + (b * 2).toString
  }

  object Fuga {
    def fuga(a: String => String) = a("hoge") * 3
    def fuga(a: (String, String) => String) = a("hoge", "fuga") * 3
  }
}
