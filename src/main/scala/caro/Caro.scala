package caro

import caro.aview.ScalaTui
import caro.aview.gui.ScalaGui
import caro.controller.Controller
import caro.model._

import scala.io.StdIn.readLine

object Caro {
  var board = new Board
  val controller = new Controller(board)
  val tui = new ScalaTui(controller)
  val gui = new ScalaGui(controller)

  def main(args: Array[String]): Unit = {
    gui.update
    gui.visible = true

    println("Welcome to Caro!\n")

    print("\nCommands:"
          + "\n\t'player1|player2 <name>' - set player names"
          + "\n\t'first <Tile color>' - start with this color tile"
          + "\n\t'board' - prints current board"
          + "\n\t'put <column> <row> <Tile color> - sets tile at position"
          + "\n\t'undo' - undo most recent move"
          + "\n\t'redo' - redo most recent undo"
          + "\n\t'quit' - exit game")

    var input: String = ""

    Thread.sleep(1000)

    do {

      printf("\nEnter your command: \n")
      input = readLine()
      tui.processInputLine(input)
    } while(input != "quit")

  }

}
