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
    println("Welcome to Caro!\nPlayer 1, please enter your name: ")
    val name1: String = readLine()
    val player1 = Player(name1)
    println("Hello, " + player1.name)

    Thread.sleep(1000)

    println("Player 2, please enter your name:")
    val name2: String = readLine()
    val player2 = Player(name2)
    println("Hello " + player2.name)

    Thread.sleep(1000)

    print("\nCommands:\n\t'board' - prints current board\n\t'new' - creates blank board\n\t"
          + "'<column> <row> <Tile color> - sets tile at position\n")

    var input: String = ""

    Thread.sleep(1000)

    do {

      printf("Enter your command: \n")
      input = readLine()
      tui.processInputLine(input)
    } while(input != "quit")

  }

}
