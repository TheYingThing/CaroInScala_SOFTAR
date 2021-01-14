package caro.model.gridComponent

import caro.model.gridComponent.boardFullImpl.GameStatus.GameStatus
import caro.model.gridComponent.boardFullImpl.{CellReplacementStrategy, Player}

import scala.collection.immutable.ListMap

trait BoardInterface {

  def getStatusMessage: String
  def getStatus: GameStatus
  def getLastColor: String
  def getCell(row: Int, col:Int): CellInterface
  def getWidth: Int
  def getHeight: Int
  def getPlayerOne: PlayerInterface
  def getPlayerTwo: PlayerInterface
  def getMoves: Int
  def setStatus(status: GameStatus): BoardInterface
  def setLastColor(lastColor: String): BoardInterface
  def setWidth(width: Int): BoardInterface
  def setHeight(height: Int): BoardInterface
  def setMoves(moves: Int): BoardInterface
  def setCell(row: Int, col: Int, color: String): BoardInterface


  def setPlayerOne(player1: Player): BoardInterface
  def setPlayerTwo(player2: Player): BoardInterface

  def isEmpty: Boolean
  def rowEmpty(row: Int): Boolean
  def colEmpty(col: Int): Boolean

  def updatePlayer(row: Int, col: Int, color: String, player: Player): (PlayerInterface, GameStatus)

  def updatedWidth(col: Int): Int
  def updatedHeight(row: Int): Int
  def replace(strategy: CellReplacementStrategy, row: Int, col: Int, color: String, status: GameStatus): BoardInterface
  def replaceCell(row: Int, col: Int, color: String): BoardInterface

  def allRules(row: Int, col: Int, color: String): Boolean

}

trait PlayerInterface {
  def getPoints: Int
  def getTiles: ListMap[String, Int]
  def getName: String
  def setPoints(points: Int): PlayerInterface
  def setTiles(tiles: ListMap[String, Int]): PlayerInterface
  def setName(name: String): PlayerInterface
}

trait CellInterface {
  def isOccupied: Boolean
  def getColor: String
}
