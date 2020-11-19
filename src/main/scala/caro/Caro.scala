package caro

import caro.aview.ScalaTui
import caro.model._

import scala.io.StdIn.readLine

object Caro {
  var board = new Board
  val tui = new ScalaTui
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

      println("\nCurrent Board State:" + board.toString)
      printf("Enter your command: \n")
      input = readLine()
      board = tui.processInputLine(input, board)
    } while(input != "quit")

    println("Cell: " + board.getCell(5, 5).getColor)
    println("Right " + board.getCell(5, 5).getRight)
    println("Left: " + board.getCell(5, 5).getLeft)
    println("Up: " + board.getCell(5, 5).getUp)
    println("Down: " + board.getCell(5, 5).getDown)

  }

}
