package caro.model.gridComponent.boardMockImpl

import caro.model.gridComponent.boardFullImpl.GameStatus.{GameStatus, IDLE}
import caro.model.gridComponent.boardFullImpl.{Board, Cell, CellReplacementStrategy, GameStatus, Player}
import caro.model.gridComponent.{BoardInterface, CellInterface, PlayerInterface, boardFullImpl}

class Board() extends BoardInterface{
  override def getStatus: GameStatus =  IDLE

  override def getLastColor: String = "red"

  override def getCell(row: Int, col: Int): CellInterface = Cell(Some("red"))

  override def getWidth: Int = 4

  override def getHeight: Int = 3

  override def getPlayerOne: PlayerInterface = Player("player1")

  override def getPlayerTwo: PlayerInterface = Player("player2")

  override def getMoves: Int = 4

  override def isEmpty: Boolean = false

  override def rowEmpty(row: Int): Boolean = false

  override def colEmpty(col: Int): Boolean = false


  override def updatePlayer(row: Int, col: Int, color: String, player: Player): (PlayerInterface, GameStatus) = (Player("player"), GameStatus.IDLE)

  override def updatedWidth(col: Int): Int = 5

  override def updatedHeight(row: Int): Int = 4

  override def replace(strategy: CellReplacementStrategy, row: Int, col: Int, color: String, status: GameStatus): BoardInterface = new Board()

  override def replaceCell(row: Int, col: Int, color: String): BoardInterface = new Board()

  override def allRules(row: Int, col: Int, color: String): Boolean = true

  override def getStatusMessage: String = "status"

  override def setPlayerOne(player: Player): boardFullImpl.Board = Board()
  override def setPlayerTwo(player: Player): boardFullImpl.Board = Board()
}
