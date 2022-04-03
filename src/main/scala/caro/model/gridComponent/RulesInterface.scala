package caro.model.gridComponent

import caro.model.gridComponent.boardFullImpl.{Board, Cell}

import scala.collection.mutable.ListBuffer

trait RulesInterface (boardInterface: BoardInterface):

  //rechts, links, oben, unten
  def getNeighbors(row: Int, col: Int): List[Cell]

  def getDiagonals(row: Int, col: Int): List[List[Cell]]

  def sameColor(row: Int, col: Int, color: String): Boolean

  def onEdge(row: Int, col: Int): Boolean

  def diagonal(row: Int, col: Int, color: String): Boolean

  //returns true if theres less than two of the same color
  def twoColor(row: Int, col: Int, color: String): Boolean

  //return true when theres no neighbor that has two neighbors that are of the same color as the tile to be laid
  def maxColor(row: Int, col: Int, color: String): Boolean

  //return true when tile can be laid
  def maxField(row: Int, col: Int): Boolean

  def allRules(row: Int, col: Int, color: String): Boolean

end RulesInterface

