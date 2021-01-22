package caro.model.gridComponent

import caro.model.gridComponent.boardFullImpl.GameStatus.GameStatus
import caro.model.gridComponent.boardFullImpl.{Board, CellReplacementStrategy, Player}

import scala.collection.immutable.ListMap

trait BoardInterface {

  def getStatusMessage: String
  def getStatus: GameStatus
  def getStatusAsString: String
  def getLastColor: String
  def getCell(row: Int, col:Int): CellInterface
  def getWidth: Int
  def getHeight: Int
  def getPlayerOne: PlayerInterface
  def getPlayerTwo: PlayerInterface
  def getMoves: Int

  def setPlayerOne(player: Player): Board
  def setPlayerTwo(player: Player): Board

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

}

trait CellInterface {
  def isOccupied: Boolean
  def getColor: String
}
