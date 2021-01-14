package caro.controller.controllerComponent.controllerMockImpl

import caro.controller.controllerComponent.ControllerInterface
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardMockImpl.Board

class Controller (var board:BoardInterface) extends ControllerInterface{

  board = new Board()

  override def newBoard(p1: String, p2: String): Unit = new Board()

  override def boardToString: String = "board"

  override def putCell(row: Int, col: Int, color: String): Unit = {}

  override def getPlayerOneName: String = "player1"

  override def getPlayerTwoName: String = "player2"

  override def playerOneToString: String = "player1 stats"

  override def playerTwoToString: String = "player 2 stats"

  override def getBoardStatus: String = "status"

  override def getCellColor(row: Int, col: Int): String = "color"

  override def getMoves: Int = 4

  override def undo: Unit = {}

  override def redo: Unit = {}

}
