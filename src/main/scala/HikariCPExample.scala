import com.zaxxer.hikari.{ HikariConfig, HikariDataSource }
import scala.util.Random

/**
 $ createdb hikaricp-example
 $ psql hikaricp-example
 CREATE TABLE person (
   id SERIAL NOT NULL PRIMARY KEY,
   name VARCHAR(254) NOT NULL
 );
 */
object HikariCPExample {
  def main(args: scala.Array[String]) = {
    val config = new HikariConfig()
    config.setDriverClassName("org.postgresql.Driver")
    config.setJdbcUrl("jdbc:postgresql:hikaricp-example")
    config.setUsername("dbuser")
    config.setPassword("dbuser")
    val ds = new HikariDataSource(config)

    val conn = ds.getConnection()

    val newName = Random.alphanumeric.take(10).mkString
    println(newName)
    val st1 = conn.prepareStatement("INSERT INTO person (name) VALUES(?)")
    st1.setString(1, newName)
    val rowsInserted = st1.executeUpdate()
    println(rowsInserted + " inserted. name = " + newName)
    st1.close()

    val limit = 3
    val st2 = conn.prepareStatement("SELECT id, name FROM person ORDER BY id DESC LIMIT ?")
    st2.setInt(1, limit)
    val rs2 = st2.executeQuery()
    while (rs2.next()) {
      println("id: " + rs2.getInt(1))
      println("name: " + rs2.getString("name"))
    }
    rs2.close()
    st2.close()

    conn.close()
  }
}
