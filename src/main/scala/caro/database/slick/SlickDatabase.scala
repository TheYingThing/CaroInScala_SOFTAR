package caro.database.slick

import caro.database.DatabaseInterface
import caro.database.slick.dataTables.{BoardTable, CellTable, PlayerTable}
import slick.dbio.DBIO
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.MySQLProfile.api.*

import scala.language.postfixOps
import concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object SlickDatabase extends DatabaseInterface :

  @main def run(): Unit = {

    val databaseUrl: String = "jdbc:mysql://localhost:3306/carodb"
    val databaseUser: String = "caro"
    val databasePassword: String = "caro"

    val database = Database.forURL(
      url = databaseUrl,
      user = databaseUser,
      password = databasePassword,
      driver = "com.mysql.cj.jdbc.Driver"
    )

    val playerTable = TableQuery[PlayerTable]
    val boardTable = TableQuery[BoardTable]
    val cellTable = TableQuery[CellTable]

    val table = DBIO.seq(
      (playerTable.schema ++ boardTable.schema ++ cellTable.schema).createIfNotExists
    )

    database.run(table).andThen {
      case Success(_) => println("Connection successful")
      case Failure(e) => println(s"Connection Failed: ${e.getMessage}")
    }
  }

  def safeToDB() : Unit = {}

  def loadFromDB() : Unit = {}

end SlickDatabase

