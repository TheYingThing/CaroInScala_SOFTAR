package caro

import caro.aview.ScalaTui
import caro.controller.Controller
import caro.model._

import scala.io.StdIn.readLine

object Caro {
  val tui = new ScalaTui(new Controller(new Board))

  def main(args: Array[String]): Unit = {

    print("Welcome to Caro!\n"
          + "\nCommands:"
          + "\n\t'player1|player2 <name>' - set player names"
          + "\n\t'first <Tile color>' - start with this color tile"
          + "\n\t'board' - prints current board"
          + "\n\t'put <column> <row> <Tile color> - sets tile at position"
          + "\n\t'undo' - undo most recent move"
          + "\n\t'redo' - redo most recent undo"
          + "\n\t'quit' - exit game")

    var input: String = ""
    if (args.length>0)
      input = args(0)
    if(!input.isEmpty)
      tui.processInputLine(input)
    else do {
      printf("\nEnter your command: \n")
      input = readLine()
      tui.processInputLine(input)
    } while(input != "quit")

  }

}
