package caro.model

class LegalMove extends CellReplacementStrategy {

  override def replacePlayer(row:Int, col:Int, color:String, thisboard:Board): Board = {
    if(thisboard.moves%2 == 0) {
      thisboard.copy(player1 = thisboard.player1.copy(points = thisboard.player1.getPoints-10))
    } else {
      thisboard.copy(player2 = thisboard.player2.copy(points = thisboard.player2.getPoints-10))
    }
  }
  override def newCell(row:Int, col:Int, color:String, thisboard:Board): Board = {
    val cell = Cell(Some(color))
    thisboard.copy(thisboard.board.updated(row, thisboard.board(row).updated(col, cell)),
      width = thisboard.updateWidth(col), height = thisboard.updatedHeight(row), moves = thisboard.moves + 1)
  }
}
