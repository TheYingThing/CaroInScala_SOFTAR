package caro.model.fileIoComponent.fileIoJsonImpl

import caro.CaroModule
import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent.*
import caro.model.gridComponent.boardFullImpl.{Board, Cell, GameStatus, Player}
import caro.model.gridComponent.boardFullImpl.GameStatus
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

    val moves = (json \ "board" \ "moves").get.toString.toInt
    val height = (json \ "board" \ "height").get.toString.toInt
    val width = (json \ "board" \ "width").get.toString.toInt
    val lastColor = (json \ "board" \ "lastColor").get.toString
    val status = (json \ "board" \ "status").get.toString
    val gameStatus: GameStatus = {
      status match {
        case "IDLE" => GameStatus.IDLE
        case "NOCOLORSLEFT" => GameStatus.NOCOLORSLEFT
        case "ILLEGALMOVE" => GameStatus.ILLEGALMOVE
        case "INVALIDCOLOR" => GameStatus.INVALIDCOLOR
      }
    }

    val player1val = (json \ "board" \ "player1").get.as[JsValue]
    val player2val = (json \ "board" \ "player2").get.as[JsValue]
    val player1 = loadPlayer(player1val)
    val player2 = loadPlayer(player2val)

    var board = Board(width = width, height = height, moves = moves, lastColor = lastColor, status = gameStatus,
      player1 = player1, player2 = player2)

    for (i <- 0 until 18 * 18 ) {
      val row = (json \\ "row")(i).as[Int]
      val col = (json \\ "col")(i).as[Int]
      val cell = (json \\ "cell")(i)
      val color = (cell \ "color").get.as[String]
      board = board.setCell(row, col , color)
    }
    board
  }

  def loadPlayer(playerVal: JsValue): Player = {
    val tileVal = (playerVal \ "player") \ "tiles"
    val redVal = (tileVal \ "red").get.toString.toInt
    val blackVal = (tileVal \ "black").as[Int]
    val greyVal = (tileVal \ "grey").as[Int]
    val whiteVal = (tileVal \ "white").as[Int]

    val nameVal = ((playerVal \ "player") \ "name").get.as[String]
    val pointVal = ((playerVal \ "player") \ "points").get.toString.toInt
    val tilesVal = ListMap("red" -> redVal, "black" -> blackVal, "grey" -> greyVal, "white" -> whiteVal)
    val player = Player(name = nameVal, tiles = tilesVal, points = pointVal)

    player
  }

  override def save(board: BoardInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.json"))

    pw.write(Json.prettyPrint(boardToJson(board)))
    pw.close
  }

  implicit val cellWrites: Writes[CellInterface] = new Writes[CellInterface] {
    def writes(cell: CellInterface) = Json.obj(
      "color" -> cell.getColor,
      "isOccupied" -> cell.isOccupied
    )
  }

  def boardToJson(board: BoardInterface): JsObject = {
    Json.obj(
      "board" -> Json.obj(
        "cells" -> Json.toJson(
          for {
            row <- 0 until 19
            col <- 0 until 19
          } yield {
            Json.obj(
              "row" -> row,
              "col" -> col,
              "cell" -> Json.toJson(board.getCell(row, col))
            )
          }
        ),
        "player1" -> playerToJson(board.getPlayerOne),
        "player2" -> playerToJson(board.getPlayerTwo),
        "moves" -> board.getMoves,
        "lastColor" -> board.getLastColor,
        "height" -> board.getHeight,
        "width" -> board.getWidth,
        "status" -> board.getStatusAsString
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
