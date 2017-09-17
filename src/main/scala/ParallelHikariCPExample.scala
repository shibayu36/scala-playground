import com.zaxxer.hikari.{ HikariConfig, HikariDataSource }

/**
 $ createdb hikaricp-example
 $ psql hikaricp-example
 CREATE TABLE person (
   id SERIAL NOT NULL PRIMARY KEY,
   name VARCHAR(254) NOT NULL
 );
 */
object ParallelHikariCPExample {
  def main(args: scala.Array[String]) = {
    val config = new HikariConfig()
    config.setDriverClassName("org.postgresql.Driver")
    config.setJdbcUrl("jdbc:postgresql:hikaricp-example")
    config.setUsername("dbuser")
    config.setPassword("dbuser")
    config.setMaximumPoolSize(3)
    val ds = new HikariDataSource(config)

    (1 to 10).par.foreach { index =>
      val conn = ds.getConnection()
      println(s"Connection $index get connection")
      Thread.sleep(index * 1000)
      conn.close()
      println(s"Connection $index close connection")
    }
  }
}
