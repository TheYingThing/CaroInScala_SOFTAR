package caro.model.fileIoComponent.fileIoXmlImpl

import caro.CaroModule
import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent.boardFullImpl.GameStatus.{GameStatus, IDLE, ILLEGALMOVE, NOCOLORSLEFT, UNVALIDCOLOR}
import caro.model.gridComponent.{BoardInterface, PlayerInterface}
import caro.model.gridComponent.boardFullImpl.{Board, Player}
import com.google.inject.Guice
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector

import scala.collection.immutable.ListMap
import scala.xml.{Elem, NodeSeq, PrettyPrinter}

class FileIO extends FileIOInterface{

  override def load: BoardInterface = {

    val file = scala.xml.XML.loadFile("board.xml")
    val boardval = (file \\ "board")

    val heightval = (boardval \ "@height").text.toInt
    val widthval = (boardval \ "@width").text.toInt
    val lastColorval = (boardval \ "@lastColor").text
    val statusval = (boardval \ "@status").text
    var gamestatus: GameStatus = null
    statusval match {
      case "IDLE" => gamestatus = IDLE
      case "NOCOLORSLEFT" => gamestatus = NOCOLORSLEFT
      case "ILLEGALMOVE" => gamestatus = ILLEGALMOVE
      case "UNVALIDCOLOR" => gamestatus = UNVALIDCOLOR
    }

    val movesval = (boardval \ "@moves").text.toInt

    val player1val = (boardval \ "@player1" \ "@player")
    val player2val = (boardval \ "@player2" \ "@player")
    val player1 = loadPlayer(player1val)
    val player2 = loadPlayer(player2val)

    var board = Board(width = widthval, height = heightval, lastColor = lastColorval, status = gamestatus, moves = movesval,
      player1 = player1, player2 = player2)

    val cellNodes = (file \\ "cells")
    for (cell <- cellNodes) {
      val row: Int = (cell \ "@row").text.toInt
      val col: Int = (cell \ "@col").text.toInt
      val color: String = cell.text.toString
      board = board.setCell(row, col, color)
    }

    board
  }

  def loadPlayer(playerVal: NodeSeq) : Player = {

    val tileval = (playerVal \ "@tiles")

    val redval = (tileval \ "@red").text.toInt
    val blackval = (tileval \ "@black").text.toInt
    val greyval = (tileval \ "@grey").text.toInt
    val whiteval = (tileval \ "@white").text.toInt

    val nameval = playerVal.text.toString
    val pointval = (playerVal \ "@points").text.toInt
    val tilesval = ListMap("red" -> redval, "black" -> blackval, "grey" -> greyval, "white" -> whiteval)

    val player = Player(name = nameval, tiles = tilesval, points = pointval)
    player
  }


  override def save(board: BoardInterface): Unit = saveString(board)

  def saveString(board: BoardInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.xml"))
    val pp = new PrettyPrinter(120, 4)
    val xml = pp.format(boardToXml(board))
    pw.write(xml)
    pw.close()
  }

  def boardToXml(board: BoardInterface) = {
    <board width={ board.getWidth.toString } height={ board.getHeight.toString } lastColor={ board.getLastColor.toString } status={board.getStatusMessage.toString}>
      <player1> { playerToXml(board.getPlayerOne) }</player1>
      <player2> { playerToXml(board.getPlayerTwo) }</player2>
      <cells>
        {
          for {
            row <- 0 until 19
            col <- 0 until 19
          } yield cellToXml(board, row, col)
        }
      </cells>
    </board>
  }

  def cellToXml(board: BoardInterface, row:Int, col:Int) = {
    <cell row={ row.toString } col={ col.toString } isOccupied={ board.getCell(row, col).isOccupied.toString }>
      { board.getCell(row, col).getColor }
    </cell>
  }

  def playerToXml(player: PlayerInterface) = {
    <player points={ player.getPoints.toString }>
      { player.getName }
      <tiles red={player.getTiles.get("red").toString} black={player.getTiles.get("black").toString}
             grey={player.getTiles.get("grey").toString} white={player.getTiles.get("white").toString}>
      </tiles>
    </player>
  }
}
