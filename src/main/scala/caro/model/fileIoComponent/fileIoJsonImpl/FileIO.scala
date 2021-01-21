package caro.model.fileIoComponent.fileIoJsonImpl

import caro.CaroModule
import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent._
import caro.model.gridComponent.boardFullImpl.{Board, Cell, Player}
import caro.model.gridComponent.boardFullImpl.GameStatus._
import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import play.api.libs.json.JsPath.\\
import play.api.libs.json.{JsArray, JsObject, JsValue, Json, Writes}

import scala.collection.immutable.ListMap
import scala.io.Source
import scala.language.postfixOps

class FileIO extends FileIOInterface {
  override def load: BoardInterface = {

    val source:String = Source.fromFile("board.json").getLines.mkString
    val json: JsValue = Json.parse(source)

    val moves = (json \ "moves").as[Int]
    val height = (json \ "height").as[Int]
    val width = (json \ "width").as[Int]
    val lastColor = (json \ "lastColor").as[String]
    val status = (json \ "status").as[String]
    var gamestatus : GameStatus = null
    status match {
      case "IDLE" => gamestatus = IDLE
      case "NOCOLORSLEFT" => gamestatus = NOCOLORSLEFT
      case "ILLEGALMOVE" => gamestatus = ILLEGALMOVE
      case "UNVALIDCOLOR" => gamestatus = UNVALIDCOLOR
    }


    val player1val = (json \ "player1").as[JsValue]
    val player2val = (json \ "player2").as[JsValue]
    val player1 = loadPlayer(player1val)
    val player2 = loadPlayer(player2val)

    var board = Board(width = width, height = height, moves = moves, lastColor = lastColor, status = gamestatus,
      player1 = player1, player2 = player2)

    for (i <- 0 until 19 * 19 ) {
      val row = (json \\ "row")(i).as[Int]
      val col = (json \\ "col")(i).as[Int]
      val cell = (json \\ "cell")(i)
      val color = (cell \ "color").as[String]
      board = board.setCell(row, col , color)
    }
    board
    }

  def loadPlayer(playerVal: JsValue): Player = {
    val tileVal = (playerVal \"tiles")
    val redVal = (tileVal \ "red").as[Int]
    val blackVal = (tileVal \ "black").as[Int]
    val greyVal = (tileVal \ "grey").as[Int]
    val whiteVal = (tileVal \ "white").as[Int]

    val nameVal = (playerVal \ "name").as[String]
    val pointVal = (playerVal \ "points").as[Int]
    val tilesVal = ListMap("red" -> redVal, "black" -> blackVal, "grey" -> greyVal, "white" -> whiteVal)


    val player = Player(name = nameVal, tiles = tilesVal, points = pointVal)

    player
  }


  implicit val playerWrites = new Writes[PlayerInterface] {
    def writes(player: PlayerInterface): JsValue =Json.obj(
      "name" -> player.getName,
      "points" -> player.getPoints,
      "tiles" -> Json.toJsFieldJsValueWrapper(player.getTiles)
    )
  }
  override def save(board: BoardInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.json"))
    pw.write(Json.prettyPrint(boardToJson(board)))
    pw.close()
  }

  implicit val cellWrites = new Writes[CellInterface] {
     def writes(cell: CellInterface): JsObject = Json.obj(
       "color" -> cell.getColor,
       "isOccupied" -> cell.isOccupied
    )
  }

  def boardToJson(board: BoardInterface): JsObject = {
    Json.obj(
      "board" -> Json.obj(
        "cell" -> Json.toJson(
          for {
            row <- 0 until 19
            col <- 0 until 19
          } yield {
            Json.obj(
              "row" -> row,
              "col" -> col,
              "cell"-> Json.toJson(board.getCell(row, col))
            )
          }
        ),
        "player1" -> playerToJson(board.getPlayerOne),
        "player2" -> playerToJson(board.getPlayerTwo)
      )
    )
  }

  def playerToJson(player:PlayerInterface): JsObject = {
    Json.obj(
      "player" -> Json.obj(
        "points" -> player.getPoints,
        "name" -> player.getName,
        "tiles" -> Json.obj(
          "red" -> player.getTiles.get("red"),
          "black" -> player.getTiles.get("black"),
          "grey" -> player.getTiles.get("grey"),
          "white" -> player.getTiles.get("white")
        )
      )
    )
  }

}
