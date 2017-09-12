import java.sql._
import scala.util.Random

/**
 $ createdb jdbc-example
 $ psql jdbc-example
 CREATE TABLE person (
   id SERIAL NOT NULL PRIMARY KEY,
   name VARCHAR(254) NOT NULL
 );
 */
object JdbcExample {
  def main(args: scala.Array[String]) = {
    Class.forName("org.postgresql.Driver")
    val db = DriverManager.getConnection(
      "jdbc:postgresql:jdbc-example",
      "dbuser",
      "dbuser"
    )

    val newName = Random.alphanumeric.take(10).mkString
    println(newName)
    val st1 = db.prepareStatement("INSERT INTO person (name) VALUES(?)")
    st1.setString(1, newName)
    val rowsInserted = st1.executeUpdate()
    println(rowsInserted + " inserted. name = " + newName)
    st1.close()

    val limit = 3
    val st2 = db.prepareStatement("SELECT id, name FROM person ORDER BY id DESC LIMIT ?")
    st2.setInt(1, limit)
    val rs2 = st2.executeQuery()
    while (rs2.next()) {
      println("id: " + rs2.getInt(1))
      println("name: " + rs2.getString("name"))
    }
    rs2.close()
    st2.close()

    db.close()
  }
}
