package caro.model.gridComponent.boardFullImpl


import caro.model.gridComponent.boardFullImpl.GameStatus

class IllegalMove extends CellReplacementStrategy :

  override def replacePlayer(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board = {
    var round: Round = new EvenRound
    if thisboard.moves % 2 == 0 then 
      round.handle(thisboard, color,status)
    else
      round = new OddRound
      round.handle(thisboard, color,status)
  }
  override def newCell(row:Int, col:Int, color:String, thisboard:Board, status:GameStatus): Board = {
    thisboard.copy(status = status)
  }
end IllegalMove

trait Round :
  def handle(thisboard:Board, color:String, status:GameStatus):Board
end Round

class EvenRound extends Round:
  override def handle(thisboard:Board, color:String, status:GameStatus):Board = {
    if thisboard.player1.getPoints - 10 < 0 then 
      thisboard.copy(player1 = thisboard.player1.copy(points = 0), status = status)
    else
     thisboard.copy(player1 = thisboard.player1.copy(points = thisboard.player1.getPoints-10), lastColor = color, status = status)
  }
end EvenRound

class OddRound extends Round :
  override def handle(thisboard:Board, color:String, status:GameStatus):Board = {
    if thisboard.player2.getPoints - 10 < 0 then 
      thisboard.copy(player2 = thisboard.player2.copy(points = 0), status = status)
    else
      thisboard.copy(player2 = thisboard.player2.copy(points = thisboard.player2.getPoints-10), lastColor = color, status = status)
  }
end OddRound


