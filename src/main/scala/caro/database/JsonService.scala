package caro.database

import caro.model.gridComponent.boardFullImpl.{Board, GameStatus, Player}
import caro.model.gridComponent.{BoardInterface, PlayerInterface}
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.collection.immutable.ListMap

object JsonService {

  def loadFromString(board: String): BoardInterface = {
    val boardJson = Json.parse(board)
    loadFromFile(boardJson)
  }

  def loadFromFile(file: JsValue): BoardInterface = {
    val moves = (file \ "board" \ "moves").get.toString.toInt
    val height = (file \ "board" \ "height").get.toString.toInt
    val width = (file \ "board" \ "width").get.toString.toInt
    val lastColor = (file \ "board" \ "lastColor").get.toString
    val status = (file \ "board" \ "status").get.toString
    val gameStatus: GameStatus = {
      status match {
        case "IDLE" => GameStatus.IDLE
        case "NOCOLORSLEFT" => GameStatus.NOCOLORSLEFT
        case "ILLEGALMOVE" => GameStatus.ILLEGALMOVE
        case "INVALIDCOLOR" => GameStatus.INVALIDCOLOR
        case _ => GameStatus.IDLE
      }
    }

    val player1val = (file \ "board" \ "player1").get.as[JsValue]
    val player2val = (file \ "board" \ "player2").get.as[JsValue]
    val player1 = loadPlayer(player1val)
    val player2 = loadPlayer(player2val)

    var board = Board(width = width, height = height, moves = moves, lastColor = lastColor, status = gameStatus,
      player1 = player1, player2 = player2)

    for
      i <- 0 until 18 * 18
    do
      val row = (file \\ "row") (i).as[Int]
      val col = (file \\ "col") (i).as[Int]
      val color = (file \\ "color") (i).as[String]
      board = board.updateCell(row, col, color)

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

  def boardToJson(board: BoardInterface): JsObject = {
    Json.obj(
      "board" -> Json.obj(
        "cells" -> Json.arr(
          for
            row <- 0 until 19
            col <- 0 until 19
          yield
            Json.obj(
              "row" -> row,
              "col" -> col,
              "color" -> board.getCell(row, col).getColor,
              "isOccupied" -> board.getCell(row, col).isOccupied
            )
        ),
        "player1" -> playerToJson(board.player1),
        "player2" -> playerToJson(board.player2),
        "moves" -> board.moves,
        "lastColor" -> board.lastColor,
        "height" -> board.height,
        "width" -> board.width,
        "status" -> board.getStatusAsString))
  }

  def playerToJson(player: PlayerInterface): JsObject = {
    Json.obj(
      "player" -> Json.obj(
        "points" -> player.points,
        "name" -> player.name,
        "tiles" -> Json.obj(
          "red" -> player.tiles.get("red"),
          "black" -> player.tiles.get("black"),
          "grey" -> player.tiles.get("grey"),
          "white" -> player.tiles.get("white"))))
  }

}
