package caro.database.slick

import caro.database.DatabaseInterface
import caro.database.slick.dataTables.{BoardTable, CellTable, PlayerTable}
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.{Board, Cell, GameStatus, Player}
import slick.dbio.{DBIO, DBIOAction}
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.MySQLProfile.api.*

import scala.language.postfixOps
import concurrent.ExecutionContext.Implicits.global
import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

class SlickDatabase extends DatabaseInterface :

  val databaseUrl: String = "jdbc:mysql://localhost:3306/carodb"
  val databaseUser: String = "caro"
  val databasePassword: String = "caro"

  val database = Database.forURL(
    url = databaseUrl,
    user = databaseUser,
    password = databasePassword,
    driver = "com.mysql.cj.jdbc.Driver"
  )

  val playerTable = new TableQuery(new PlayerTable(_))
  val boardTable = TableQuery[BoardTable]
  val cellTable = TableQuery[CellTable]

  def safeToDB(board: BoardInterface): Unit = {
    val i = (3 to 15).toList
    var cellList: List[(Int, Int, String)] = List()

    i.foreach(x =>
      i.foreach(y =>
        val color: String = board.getCell(x, y).getColor
        if !color.equals("none") then cellList::=(x, y, color)
      )
    )

    val player1 = board.player1
    val player2 = board.player2

    val actions = for {
      tables <- (playerTable.schema ++ boardTable.schema ++ cellTable.schema)createIfNotExists;
      playerId1 <- (playerTable returning playerTable.map(_.id)) += (0, player1.name, player1.tiles("red"), player1.tiles("black"), player1.tiles("grey"), player1.tiles("white"), player1.points)
      playerId2 <- (playerTable returning playerTable.map(_.id)) += (0, player2.name, player2.tiles("red"), player2.tiles("black"), player2.tiles("grey"), player2.tiles("white"), player2.points)
      boardId <- (boardTable returning boardTable.map(_.id)) += (0, board.width, board.height, board.moves, board.lastColor, board.getStatusAsString, playerId1, playerId2)
      cells <- cellTable ++= cellList.map(cell => (0, cell._1, cell._2, cell._3, boardId))
    } yield (tables, playerId1, playerId2, boardId, cells)

    database.run(actions.transactionally).andThen {
      case Success(_) => println("Values saved")
      case Failure(e) => println(s"Failed to save: ${e.getMessage}")
    }
  }

  def loadFromDB(): Board = {
    val boardIdQuery = sql"""SELECT MAX(id) FROM BOARDS""".as[Int]
    val boardId = Await.result(database.run(boardIdQuery), Duration.Inf).head

    val boardQuery = sql"""SELECT * FROM BOARDS WHERE id = $boardId""".as[(Int, Int, Int, Int, String, String, Int, Int)]
    val board = Await.result(database.run(boardQuery), Duration.Inf).head

    val player1Id = board(6)
    val player2Id = board(7)

    val player1Query = sql"""SELECT * FROM PLAYER WHERE id = $player1Id""".as[(Int, String, Int, Int, Int, Int, Int)]
    val player1 = Await.result(database.run(player1Query), Duration.Inf).head

    val player2Query = sql"""SELECT * FROM PLAYER WHERE id = $player2Id""".as[(Int, String, Int, Int, Int, Int, Int)]
    val player2 = Await.result(database.run(player2Query), Duration.Inf).head

    val cellsQuery = sql"""SELECT * FROM CELLS WHERE board_id = $boardId""".as[(Int, Int, Int, String, Int)]
    val cells = Await.result(database.run(cellsQuery), Duration.Inf)

    val loadedPlayer1 = Player(player1(1), ListMap("red" -> player1(2), "black" -> player1(3), "grey" -> player1(4), "white" -> player1(5)), player1(6))
    val loadedPlayer2 = Player(player2(1), ListMap("red" -> player2(2), "black" -> player2(3), "grey" -> player2(4), "white" -> player2(5)), player2(6))

    val cellVector: Vector[Vector[Cell]] = Vector.fill(19, 19)(Cell(None))

    val gameStatus: GameStatus = {
      board(5) match {
        case "IDLE" => GameStatus.IDLE
        case "NOCOLORSLEFT" => GameStatus.NOCOLORSLEFT
        case "ILLEGALMOVE" => GameStatus.ILLEGALMOVE
        case "INVALIDCOLOR" => GameStatus.INVALIDCOLOR
        case _ => GameStatus.IDLE
      }
    }

    var loadedBoard = Board(cellVector, board(1), board(2), board(3), board(4), gameStatus, loadedPlayer1, loadedPlayer2)
    cells.foreach(c => loadedBoard = loadedBoard.updateCell(c(1), c(2), c(3)))
    println(loadedBoard.toString)
    loadedBoard
  }

end SlickDatabase

