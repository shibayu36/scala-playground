object MapExample {
  def main(args: Array[String]): Unit = {
    val urls = Map(
      "www"  -> "http://www.hatena.ne.jp",
      "b"    -> "http://b.hatena.ne.jp",
      "blog" -> "http://hatenablog.com"
    )

    val bUrl = urls.get("b") // Some("http://b.hatena.ne.jp")
    val vUrl = urls.get("v") // None

    // 方法1 (bad)
    // bUrl.get // SomeかNoneか無視してとりだす/基本的に使わない
    // vUrl.get // ランタイムエラー!!

    // 方法2
    bUrl.getOrElse("no url") // Someだったら中身の値
    vUrl.getOrElse("no url") // Noneだったらデフォルト値

    // 方法3
    bUrl match { // パターンマッチでそれぞれ処理する
      case Some(url) =>
        println(s"bのURLは $url ですぞ")
      case None =>
        println("no url")
    }

    vUrl match {
      case Some(url) =>
        println(s"vのURLは $url ですぞ")
      case None =>
        println("no url")
    }
  }
}
