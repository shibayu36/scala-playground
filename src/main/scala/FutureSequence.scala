import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Promise, Future, Await}
import scala.concurrent.duration.Duration

object FutureSequence extends App {
  val futures: List[Future[Int]] = (1 to 12).toList.map { i =>
    println("before : " + i)
    Future {
      println(i)
      Thread.sleep(1000)
      i
    }
  }

  val f: Future[List[Int]] = Future.sequence(futures)
  f.onSuccess{ case result => println(result.mkString) }

  Await.ready(f, Duration.Inf)
}
