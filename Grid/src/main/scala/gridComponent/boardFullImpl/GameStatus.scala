package gridComponent.boardFullImpl

enum GameStatus(message:String) :
  case IDLE extends GameStatus("")
  case NOCOLORSLEFT extends GameStatus("\nNo Tiles of this Color left!\n")
  case ILLEGALMOVE extends GameStatus("\nIllegal Move! Minus 10 Points!\n")
  case INVALIDCOLOR extends GameStatus("\nNot a valid Color!\n")

  def getMessage: String = message

  def getString(gameStatus: GameStatus): String = {
    gameStatus match {
      case IDLE => "IDLE"
      case NOCOLORSLEFT => "NOCOLORSLEFT"
      case ILLEGALMOVE => "ILLEGALMOVE"
      case INVALIDCOLOR => "INVALIDCOLOR"
    }
  }
  
end GameStatus