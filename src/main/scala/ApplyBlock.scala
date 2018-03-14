object ApplyBlock {
  def main(args: Array[String]): Unit = {
    val a = (new WantBlock) { arg =>
      arg * 3
    }
    println(a)

    val b = (new WantBlock) { (arg1, arg2) =>
      arg1 + arg2
    }
    println(b)
  }

  class WantBlock {
    def apply(withArg: String => String): String = {
      withArg("hoge")
    }

    def apply(withArg2: (String, String) => String): String = {
      withArg2("hoge", "fuga")
    }
  }
}
