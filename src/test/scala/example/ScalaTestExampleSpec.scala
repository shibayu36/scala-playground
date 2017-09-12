package example
import org.scalatest._

class ScalaTestExampleSpec extends FunSpec with Matchers {
  describe("ScalaTestExample#greeting") {
    it("Returns hello") {
      ScalaTestExample.greeting shouldEqual "hello"
    };
  }

  describe("ScalaTestExample#list") {
    it("Returns list") {
      ScalaTestExample.list shouldBe List(1,3,2)
    };
  }
}
