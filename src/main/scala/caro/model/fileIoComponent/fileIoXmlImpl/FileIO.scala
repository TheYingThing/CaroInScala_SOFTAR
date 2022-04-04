package caro.model.fileIoComponent.fileIoXmlImpl

import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent.boardFullImpl.{Board, GameStatus, Player}
import caro.model.gridComponent.{BoardInterface, PlayerInterface}

import scala.collection.immutable.ListMap
import scala.xml.{Elem, NodeSeq, PrettyPrinter}

class FileIO extends FileIOInterface :

  override def load: BoardInterface = {

    val file = scala.xml.XML.loadFile("board.xml")
    file.attribute("tiles")
    val boardval = file \\ "board"

    val heightval = (boardval \ "@height").text.trim.toInt
    val widthval = (boardval \ "@width").text.trim.toInt
    val lastColorval = (boardval \ "@lastColor").text
    val movesval = (boardval \ "@moves").text.trim.toInt
    val statusval = (boardval \ "@status").text
    val gamestatus: GameStatus = {
      statusval match {
        case "IDLE" => GameStatus.IDLE
        case "NOCOLORSLEFT" => GameStatus.NOCOLORSLEFT
        case "ILLEGALMOVE" => GameStatus.ILLEGALMOVE
        case "UNVALIDCOLOR" => GameStatus.INVALIDCOLOR
      }
    }

    val player1val = (boardval \ "player1") \ "player"
    val player2val = (boardval \ "player2") \ "player"
    val player1 = loadPlayer(player1val)
    val player2 = loadPlayer(player2val)

    var board = Board(width = widthval, height = heightval, lastColor = lastColorval, status = gamestatus,
      moves = movesval, player1 = player1, player2 = player2)

    val cellNodes = (file \ "cells") \ "cell"
    for
      cell <- cellNodes
    do
      val row: Int = (cell \ "@row").text.trim.toInt
      val col: Int = (cell \ "@col").text.trim.toInt
      val color: String = (cell \ "color").text.trim
      board = board.updateCell(row, col, color)

    board
  }

  def loadPlayer(playerVal: NodeSeq): Player = {

    val tileval = playerVal \ "tiles"

    val nameval = (playerVal \ "name").text
    val pointval = (playerVal \ "points").text.trim.toInt

    val redval = (tileval \ "red").text.trim.toInt
    val blackval = (tileval \ "black").text.trim.toInt
    val greyval = (tileval \ "grey").text.trim.toInt
    val whiteval = (tileval \ "white").text.trim.toInt

    val tilesval = ListMap("red" -> redval, "black" -> blackval, "grey" -> greyval, "white" -> whiteval)

    val player = Player(name = nameval, tiles = tilesval, points = pointval)
    player
  }


  override def save(board: BoardInterface): Unit = saveString(board)

  def saveString(board: BoardInterface): Unit = {
    import java.io.*
    new File("board.xml").delete()
    val pw = new PrintWriter(new File("board.xml"))
    val pp = new PrettyPrinter(120, 4)
    val xml = pp.format(boardToXml(board))
    pw.write(xml)
    pw.close()
  }

  def boardToXml(board: BoardInterface): Elem = {
    <board moves={board.getMoves.toString} width={board.getWidth.toString} height={board.getHeight.toString}
           lastColor={board.getLastColor} status={board.getStatusAsString}>
      <player1>
        {playerToXml(board.getPlayerOne)}
      </player1>
      <player2>
        {playerToXml(board.getPlayerTwo)}
      </player2>
      <cells>
        {for
        row <- 0 until 18
        col <- 0 until 18
      yield cellToXml(board, row, col)}
      </cells>
    </board>
  }

  def cellToXml(board: BoardInterface, row: Int, col: Int): Elem = {
    <cell row={row.toString} col={col.toString} isOccupied={board.getCell(row, col).isOccupied.toString}>
      <color>
        {board.getCell(row, col).getColor}
      </color>
    </cell>
  }

  def playerToXml(player: PlayerInterface): Elem = {
    <player>
      <name>
        {player.getName}
      </name>
      <points>
        {player.getPoints.toString}
      </points>
      <tiles>
        <red>
          {player.getTiles("red").toString}
        </red>
        <black>
          {player.getTiles("black").toString}
        </black>
        <grey>
          {player.getTiles("grey").toString}
        </grey>
        <white>
          {player.getTiles("white").toString}
        </white>
      </tiles>
    </player>
  }
end FileIO
