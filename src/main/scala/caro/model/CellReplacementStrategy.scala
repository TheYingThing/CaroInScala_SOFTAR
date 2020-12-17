package caro.model

import caro.model.GameStatus.GameStatus

trait CellReplacementStrategy {
  def newBoard(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board = {
    var nboard = replacePlayer(row, col, color, thisboard, status)
    if(nboard.player1 == thisboard.player1 && nboard.player2 == thisboard.player2)
      return thisboard.copy(status = nboard.status)
    nboard = newCell(row, col, color, nboard, nboard.status)
    nboard
  }
  def replacePlayer(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board
  def newCell(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board
}