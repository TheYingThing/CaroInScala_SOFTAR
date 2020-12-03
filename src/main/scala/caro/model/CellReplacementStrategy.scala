package caro.model

trait CellReplacementStrategy {
  def newBoard(row:Int, col:Int, color:String, thisboard:Board): Board = {
    var nboard = replacePlayer(row, col, color, thisboard)
    if(nboard.player1 == thisboard.player1 && nboard.player2 == thisboard.player2)
      return thisboard
    nboard = newCell(row, col, color, nboard)
    nboard
  }
  def replacePlayer(row:Int, col:Int, color:String, thisboard:Board): Board
  def newCell(row:Int, col:Int, color:String, thisboard:Board): Board
}