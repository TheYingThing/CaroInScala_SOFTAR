package caro.model.fileIoComponent.fileIoJsonImpl

import caro.CaroModule
import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent._
import caro.model.gridComponent.boardFullImpl.Cell
import com.google.inject.Guice
import play.api.libs.json.JsPath.\\
import play.api.libs.json.{JsArray, JsValue, Json, Writes}

import scala.collection.immutable.ListMap
import scala.io.Source
import scala.language.postfixOps

class FileIO extends FileIOInterface {
  override def load: BoardInterface = {

    var board:BoardInterface = null
    val source:String = Source.fromFile("board.json").getLines.mkString
    val json: JsValue = Json.parse(source)
    val injector = Guice.createInjector(new CaroModule)

    val moves = (json \ "moves").as[Int]
    val height = (json \ "height").as[Int]
    val width = (json \ "width").as[Int]
    val lastColor = (json \ "lastColor").as[String]
    val cell = (json \ "cell")
    val status = (json \ "status").as[String]

    val player1val = (json \ "player1" \ "player")
    val player2val = (json \ "player2" \ "player")
    board
    }

  def loadPlayer(playerVal: JsArray): PlayerInterface = {
    val tileVal = (playerVal \"tiles")
    val redVal = (tileVal \ "red").as[Int]
    val blackVal = (tileVal \ "black").as[Int]
    val greyVal = (tileVal \ "grey").as[Int]
    val whiteVal = (tileVal \ "white").as[Int]

    val nameVal = (playerVal \ "name").as[String]
    val pointVal = (playerVal \ "points").as[Int]
    val tilesVal = ListMap("red" -> redVal, "black" -> blackVal, "grey" -> greyVal, "white" -> whiteVal)

    val injector = Guice.createInjector(new CaroModule)


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
    pw.close
  }

  implicit val cellWrites = new Writes[CellInterface] {
     def writes(cell: CellInterface) = Json.obj(
       "color" -> cell.getColor,
       "isOccupied" -> cell.isOccupied
    )
  }

  def boardToJson(board: BoardInterface) = {
    Json.obj(
      "board" -> Json.obj(
        "cell" -> Json.toJson(
          for {
            row <- 0 until 19;
            col <- 0 until 19
          } yield {
            Json.obj(
              "row" -> row,
              "col" -> col,
              "cell"-> Json.toJson(board.getCell(row, col))
            )
          }
        )
      )
    )
  }

  def playerToJson

}
