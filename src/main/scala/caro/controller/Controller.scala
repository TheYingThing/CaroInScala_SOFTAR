package caro.controller

import caro.model._
import caro.util.Observable

class Controller(var board: Board) extends Observable {
  val rule:Rules = new Rules(board)
  def newBoard():Unit = {
    board = Board()
    notifyObservers
  }

  def boardToString: String = board.toString

  def putCell(row: Int, col:Int, cell:Cell) :Unit = {

    if (rule.onEdge(row, col)) {
      if (rule.sameColor(row, col, cell)) {
        if (!rule.diagonal(row, col, cell)) {
          board = board.replaceCell(row, col, cell)
          notifyObservers
        }
      }
    }
  }
}
