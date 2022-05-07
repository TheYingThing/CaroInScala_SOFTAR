import tuiComponent.ScalaTui

import scala.io.StdIn.readLine


object Tui {
  @main def run(): Unit = {
    val tui = ScalaTui()

    println("Welcome to Caro!\n")

    print("\nCommands:"
      + "\n\t'player1|player2 <name>' - set player names"
      + "\n\t'first <Tile color>' - start with this color tile"
      + "\n\t'board' - prints current board"
      + "\n\t'put <column> <row> <Tile color> - sets tile at position"
      + "\n\t'undo' - undo most recent move"
      + "\n\t'redo' - redo most recent undo"
      + "\n\t'quit' - exit game"
      + "\n\t'save' - save current game"
      + "\n\t'load' - load saved game")

    var input: String = ""

    Thread.sleep(1000)

    while
      printf("\nEnter your command: \n")
      input = readLine()
      tui.processInputLine(input)
      input != "quit"
    do ()
  }

}
