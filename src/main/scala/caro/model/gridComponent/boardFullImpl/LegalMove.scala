package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.boardFullImpl.GameStatus.GameStatus

class LegalMove extends CellReplacementStrategy {

  override def replacePlayer(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board = {
    if(thisboard.moves%2 == 0) {
      val p1:(Player, GameStatus) = thisboard.updatePlayer(row, col, color, thisboard.player1)
      thisboard.copy(player1 = p1._1,status = p1._2)
    } else {
      val p2:(Player,GameStatus) = thisboard.updatePlayer(row, col, color, thisboard.player2)
      thisboard.copy(player2 = p2._1, status = p2._2)
    }
  }
  override def newCell(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board = {
    val cell = Cell(Some(color))
    thisboard.copy(thisboard.board.updated(row, thisboard.board(row).updated(col, cell)),
      width = thisboard.updatedWidth(col), height = thisboard.updatedHeight(row), moves = thisboard.moves + 1, status = status)
  }
}
