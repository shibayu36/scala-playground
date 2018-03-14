import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Promise, Future}
import scala.util.Random
import org.joda.time.{ DateTimeUtils, DateTime }

object FakeTimer extends App {
  val random = new Random()
  val futures: Seq[Future[Int]] = for {i <- 1 to 8} yield Future[Int] {
    val waitMilliSec = i * 1000
    DateTimeUtils.setCurrentMillisFixed(waitMilliSec)
    Thread.sleep(waitMilliSec)
    println(i + " : " + DateTime.now)
    waitMilliSec
  }
  Thread.sleep(5000)
  DateTimeUtils.setCurrentMillisSystem()
  println("system : " + DateTime.now)
  Thread.sleep(10000)
}
