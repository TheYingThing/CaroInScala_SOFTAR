package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.RulesInterface
import caro.model.gridComponent.boardFullImpl.Board

import scala.collection.mutable.ListBuffer

case class Rules(board: Board) extends RulesInterface(board:Board):

  val maxSize: Int = 6

//rechts, links, oben, unten
  def getNeighbors(row: Int, col: Int): List[Cell] = {
    board.getCell(row, col + 1) :: board.getCell(row, col - 1) :: board.getCell(row - 1, col) :: board.getCell(row + 1, col) :: Nil
  }

  def getDiagonals(row: Int, col: Int): List[List[Cell]] = {
    val r1 = row - 3
    val c = col - 3
    val r2 = row + 3
    val buftop = ListBuffer.empty[Cell]
    val bufbottom = ListBuffer.empty[Cell]
    (0 to 6).toList.foreach(x => {
      buftop += board.getCell(r1 + x, c + x)
      bufbottom += board.getCell(r2 - x, c + x)
    })
    var top = buftop.toList
    var bottom = bufbottom.toList
    top = top.take(3) ++ top.drop(4)
    bottom = bottom.take(3) ++ bottom.drop(4)
    top :: bottom :: Nil
  }

  def sameColor(row: Int, col: Int, color: String): Boolean = {
    getNeighbors(row, col).forall(n => n.getColor != color)
  }

  def onEdge(row: Int, col: Int): Boolean = {
    getNeighbors(row, col).exists(n => n.isOccupied)
  }

  def diagonal(row: Int, col: Int, color: String): Boolean = {
    val diag1 = getDiagonals(row, col).head.sliding(3).toList
    val diag2 = getDiagonals(row, col)(1).sliding(3).toList
    !(diag1.exists(l => l.forall(c => c.getColor == color)) || diag2.exists(l => l.forall(c => c.getColor == color))) //true when theres a sequence of 3 same colors

  }

  //returns true if theres less than two of the same color
  def twoColor(row: Int, col: Int, color: String): Boolean = {
    val counter: Int = getNeighbors(row, col).count(n => n.getColor == color)
    counter < 2
  }

  //return true when theres no neighbor that has two neighbors that are of the same color as the tile to be laid
  def maxColor(row: Int, col: Int, color: String): Boolean = {
    twoColor(row - 1, col, color) && twoColor(row + 1, col, color) && twoColor(row, col + 1, color) && twoColor(row, col - 1, color)
  }

  //return true when tile can be laid
  def maxField(row: Int, col: Int): Boolean = {
    if (board.getHeight == maxSize && board.rowEmpty(row)) || (board.getWidth == maxSize && board.colEmpty(col)) then
      return false
    true
  }

  def allRules(row: Int, col: Int, color: String): Boolean = {
    if board.isEmpty && row == 9 && col == 9 || color == "none" then
      true
    else
      sameColor(row, col, color) && onEdge(row, col) && diagonal(row, col, color) && maxColor(row, col, color) && maxField(row, col) && (!this.board.getCell(row, col).isOccupied)
  }

end Rules
