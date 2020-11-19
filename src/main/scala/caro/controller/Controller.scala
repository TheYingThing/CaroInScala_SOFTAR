package caro.controller

import caro.model.{Board,Cell,Player}
import caro.util.Observable

class Controller(var board:Board) extends Observable {
  def emptyBoard():Unit = {
    board = new Board()
    notifyObservers
  }

  def boardToString: String = board.toString

  def put(row: Int, col: Int, color:String):Unit = {
    board = board.replaceCell(row, col, color)
    notifyObservers
  }

}
