package caro.controller.controllerComponent.controllerMockImpl

import caro.controller.controllerComponent.ControllerInerface
import caro.model._

class Controller (var board:Board) extends ControllerInerface{

  board = Board()

  override def newBoard(p1: String, p2: String): Unit = Board(player1 = Player(p1), player2 = Player(p2))

  override def boardToString: String = board.toString

  override def putCell(row: Int, col: Int, color: String): Unit = board.replaceCell(row, col, color)

  override def correctCell(row: Int, col: Int): Unit = board.replaceCell(row, col, board.lastColor)

  override def getPlayerOneName: String = board.player1.getName

  override def getPlayerTwoName: String = board.player2.getName

  override def playerOneToString: String = board.player1.toString

  override def playerTwoToString: String = board.player2.toString

  override def getBoardStatus: String = board.getStatus

  override def getCellColor(row: Int, col: Int): String = board.getCell(row, col).getColor

  override def getMoves: Int = board.moves

  override def undo: Unit = {}

  override def redo: Unit = {}

}
