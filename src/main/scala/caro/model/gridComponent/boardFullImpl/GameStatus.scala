package caro.model.gridComponent.boardFullImpl

object GameStatus extends Enumeration {
  type GameStatus = Value
  val NOCOLORSLEFT, ILLEGALMOVE, UNVALIDCOLOR, IDLE = Value

  val map: Map[GameStatus, String] = Map[GameStatus, String](
    IDLE -> "",
    NOCOLORSLEFT -> "\nNo Tiles of this Color left!\n",
    ILLEGALMOVE -> "\nIllegal Move! Minus 10 Points!\n",
    UNVALIDCOLOR -> "\nNot a valid Color!\n"
  )

  def message(gameStatus: GameStatus): String = {
    map(gameStatus)
  }
}
