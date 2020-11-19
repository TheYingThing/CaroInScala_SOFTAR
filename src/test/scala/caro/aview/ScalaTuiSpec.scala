package caro.aview

import caro.model._
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._

class ScalaTuiSpec extends AnyWordSpec with should.Matchers{

  "A Caro Tui" should {
    val tui = new ScalaTui()
    val board = new Board()
    "print the board on input 'board" in {
      tui.processInputLine("board", board) should be(board)
    }
    "create a new board on input 'new'" in {
      tui.processInputLine("new", board) should be(new Board())
    }
    "set a tile on input '4 5 red'" in {
      tui.processInputLine("4 5 red", board).getCell(3, 4) should be ("red")
    }
    "not set a tile on input 'red'" in {
      tui.processInputLine("red", board) should be(board)
    }
   }
}
