package caro.model

class LegalMove extends CellReplacementStrategy {

  override def replacePlayer(row:Int, col:Int, color:String, thisboard:Board): Board = {
    if(thisboard.moves%2 == 0) {
      thisboard.copy(player1 = thisboard.updatePlayer(row, col, color, thisboard.player1))
    } else {
      thisboard.copy(player2 = thisboard.updatePlayer(row, col, color, thisboard.player2))
    }
  }
  override def newCell(row:Int, col:Int, color:String, thisboard:Board): Board = {
    var cell = Cell(Some(color))
    if(color == "none")
      cell = Cell(None)
    thisboard.copy(thisboard.board.updated(row, thisboard.board(row).updated(col, cell)),
      width = thisboard.updateWidth(col), height = thisboard.updatedHeight(row), moves = thisboard.moves + 1)
  }
}
