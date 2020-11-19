package caro.aview

import caro.model._
import org.scalatest.matchers._
import org.scalatest.wordspec._

class TuiSpec extends AnyWordSpec with should .Matchers {

  "A caro TUI" should {
    val tui = new ScalaTui()
    val board = Board()
    "print the board on input 'board'" in {
      tui.processInputLine("board", board) should be (board)
    }
    "create a new board on input 'new'" in {
      tui.processInputLine("new", board) should be (Board())
    }
    "set a Tile on input '4 5 red'" in {
      tui.processInputLine("4 5 red", board).getCell(3,4).getColor should be("red")
    }
    "not set a Tile on input 'red'" in {
      tui.processInputLine("red", board) should be (board)
    }
  }

}
