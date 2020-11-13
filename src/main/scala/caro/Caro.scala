package caro

import caro.model._
import scala.io.StdIn.readLine

object Caro {
  var board = new Board
  val tui = new ScalaTui
  def main(args: Array[String]): Unit = {
    println("Welcome to Caro!\n")
    val student = Player("Ying and Rebecca")
    println("Hello, " + student.name)

    printf("Commands:\n\t'board' - prints current board\n\t'new' - creates blank board\n\t"
          + "'<column> <row> <Tile color> - sets tile at position")

    var input: String = ""
    do {

      println("Current Board State: " + board.toString)
      input = readLine()
      board = tui.processInputLine(input, board)
    } while(input != "quit")

  }

}
