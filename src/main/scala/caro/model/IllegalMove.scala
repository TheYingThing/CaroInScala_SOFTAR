package caro.model

class IllegalMove extends CellReplacementStrategy {

  override def replacePlayer(row:Int, col:Int, color:String, thisboard:Board): Board = {
    if(thisboard.moves%2 == 0) {
      if (thisboard.player1.getPoints - 10 < 0) {
        return thisboard.copy(player1 = thisboard.player1.copy(points = 0))
      }
      return thisboard.copy(player1 = thisboard.player1.copy(points = thisboard.player1.getPoints-10))
    } else {
      if (thisboard.player2.getPoints - 10 < 0) {
        return thisboard.copy(player2 = thisboard.player2.copy(points = 0))
      }
      return thisboard.copy(player2 = thisboard.player2.copy(points = thisboard.player2.getPoints-10))
    }
  }
  override def newCell(row:Int, col:Int, color:String, thisboard:Board): Board = {
    thisboard
  }
}
