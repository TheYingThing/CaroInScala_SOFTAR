package caro.controller

import caro.model.{Board, Player}
import caro.util.Observable

class Controller(var board:Board) extends Observable {

  def newBoard(p1:String, p2:String):Unit = {
    val nplayer1:Player = Player(p1)
    val nplayer2:Player = Player(p2)
    board = Board(player1 = nplayer1, player2 = nplayer2)
    notifyObservers
  }

  def boardToString: String = board.toString

  def putCell(row: Int, col: Int, color:String):Unit = {
    board = board.replaceCell(row, col, color)
    notifyObservers

  }



}
