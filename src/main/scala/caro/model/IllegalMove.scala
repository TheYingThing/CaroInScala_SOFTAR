package caro.model

class IllegalMove extends CellReplacementStrategy {

  override def replacePlayer(row:Int, col:Int, color:String, thisboard:Board): Board = {
    var round: Round = new EvenRound
    if (thisboard.moves % 2 == 0) {
      round.handle(thisboard, color)
    } else {
      round = new OddRound
      round.handle(thisboard, color)
    }
  }
  override def newCell(row:Int, col:Int, color:String, thisboard:Board): Board = {
    thisboard
  }
}

trait Round {
  def handle(thisboard:Board, color:String):Board
}

class EvenRound extends Round{
  override def handle(thisboard:Board, color:String):Board = {
    if (thisboard.player1.getPoints - 10 < 0) {
      thisboard.copy(player1 = thisboard.player1.copy(points = 0))
    } else {
     thisboard.copy(player1 = thisboard.player1.copy(points = thisboard.player1.getPoints-10), lastColor = color)
    }
  }
}

class OddRound extends Round {
  override def handle(thisboard:Board, color:String):Board = {
    if (thisboard.player2.getPoints - 10 < 0) {
      thisboard.copy(player2 = thisboard.player2.copy(points = 0))
    } else {
      thisboard.copy(player2 = thisboard.player2.copy(points = thisboard.player2.getPoints-10), lastColor = color)
    }
  }
}

