import com.zaxxer.hikari.{ HikariConfig, HikariDataSource }
import java.sql._
import me.geso.nanobench.Benchmark;

object HikariCPBenchmark {
  def main(args: scala.Array[String]): Unit = {
    new Benchmark(HikariCPBenchmarkInner).warmup(1).runByTime(3).timethese().cmpthese()
  }
}

object HikariCPBenchmarkInner {
  @Benchmark.Bench
  def jdbc: Unit = {
    Class.forName("org.postgresql.Driver")

    for (i <- 1 to 100) {
      val conn = DriverManager.getConnection(
        "jdbc:postgresql:hikaricp-example",
        "dbuser",
        "dbuser"
      )
      conn.close()
    }
  }

  @Benchmark.Bench
  def hikaricp: Unit = {
    val config = new HikariConfig()
    config.setDriverClassName("org.postgresql.Driver")
    config.setJdbcUrl("jdbc:postgresql:hikaricp-example")
    config.setUsername("dbuser")
    config.setPassword("dbuser")
    val ds = new HikariDataSource(config)

    for (i <- 1 to 100) {
      val conn = ds.getConnection()
      conn.close()
    }
    ds.close()
  }
}
