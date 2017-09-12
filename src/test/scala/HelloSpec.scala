import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    val hoge = "abc" * 3
    val fuga = 5 * 10
    val list = Seq(1,3,5)
    Hello.greeting shouldEqual "hello"
  }
}
