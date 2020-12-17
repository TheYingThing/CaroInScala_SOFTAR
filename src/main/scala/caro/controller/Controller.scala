package caro.controller

import caro.model.{Board, Player}
import caro.util._

import scala.swing.Publisher

class Controller(var board:Board) extends Observable{
  private val undoManager = new UndoManager
  def newBoard(p1:String, p2:String):Unit = {
    val nplayer1:Player = Player(p1)
    val nplayer2:Player = Player(p2)
    board = Board(player1 = nplayer1, player2 = nplayer2)
    notifyObservers()
  }

  def boardToString: String = board.toString

  def putCell(row: Int, col: Int, color:String):Unit = {
    undoManager.doStep(new ReplaceCommand(row, col, color, this))
    notifyObservers()
  }

  def correctCell(row: Int, col:Int):Unit = {
    undoManager.doStep(new CorrectionCommand(row, col, this))
    notifyObservers()
  }

  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers()
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers()
  }


}
