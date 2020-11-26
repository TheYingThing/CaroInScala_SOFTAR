package caro

import caro.aview.ScalaTui
import caro.controller.Controller
import caro.model._

import scala.io.StdIn.readLine

object Caro {
  var board = new Board
  val controller = new Controller(board)
  val tui = new ScalaTui(controller)

  def main(args: Array[String]): Unit = {
    println("Welcome to Caro!\n")

    print("\nCommands:"
          + "\n\t'player1|player2 <name>' - set player names"
          + "\n\t'start' - creates blank board with player names"
          + "\n\t'first <Tile color>' - start with this color tile"
          + "\n\t'board' - prints current board"
          + "\n\t'<column> <row> <Tile color> - sets tile at position")

    var input: String = ""

    Thread.sleep(1000)

    do {

      printf("Enter your command: \n")
      input = readLine()
      tui.processInputLine(input)
    } while(input != "quit")

  }

}
