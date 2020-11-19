package caro.controller

import caro.model.{Board,Cell,Rules}
import caro.util.Observable

class Controller(var board:Board) extends Observable {
  val rule:Rules = new Rules(board)

  def newBoard():Unit = {
    board = new Board()
    notifyObservers
  }

  def boardToString: String = board.toString

  def putCell(row: Int, col: Int, color:String):Unit = {

    board = board.replaceCell(row, col, color)
    notifyObservers
  }



}
