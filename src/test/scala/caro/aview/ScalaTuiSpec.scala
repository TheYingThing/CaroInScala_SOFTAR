package caro.aview

import caro.controller.controllerComponent.controllerBaseImpl.Controller
import caro.model.gridComponent.boardFullImpl.Board
import org.scalatest.matchers._
import org.scalatest.wordspec._

class ScalaTuiSpec extends AnyWordSpec with should.Matchers {

  "A Caro Tui" should {
    val board = Board()
    val cont = new Controller(board)
    val tui = new ScalaTui(cont)

    "print the board on input 'board" in {
      tui.processInputLine("board")
      cont.board should be(board)
    }

    "not do anything on input 'undo' if the board is empty" in {
      tui.processInputLine("undo")
      cont.board should be(board)
    }

    "not do anything on input 'redo' if the board is empty" in {
      tui.processInputLine("redo")
      cont.board should be(board)
    }

    "set a tile on input 'first red'" in {
      tui.processInputLine("first red")
      cont.board.getCell(9, 9).getColor should be("red")
    }

    "set a tile on input 'put 9 10 black'" in {
      tui.processInputLine("put 7 8 black")
      cont.board.getCell(9, 10).getColor should be("black")
    }

    "set a name for player1 on input 'player1 Sam'" in {
      tui.processInputLine("player1 Sam")
      cont.board.getPlayerOne.getName should be("Sam")
      cont.board.getPlayerTwo.getName should be("player2")
    }

    "set a name for player2 on input 'player2 Mike'" in {
      tui.processInputLine("player2 Mike")
      cont.board.getPlayerTwo.getName should be("Mike")
      cont.board.getPlayerOne.getName should be("Sam")
    }

    "undo the most recent move on input 'undo'" in {
      tui.processInputLine("undo")
      cont.board.getCell(9, 10).getColor should be("none")
    }

    "redo the most recent move on input 'redo'" in {
      tui.processInputLine("redo")
      cont.board.getCell(9, 10).getColor should be("black")
    }

    "exit the game on input'quit'" in {
      tui.processInputLine("quit")
      cont.board should be(cont.board)
    }

    "not do anything on wrong input" in {
      tui.processInputLine("wrong")
      cont.board should be(cont.board)
    }

    "save the current board" in {
      tui.processInputLine("save")
      cont.board should be(cont.board)
    }

    "load the saved board" in {
      tui.processInputLine("player1 boy")
      cont.board.getCell(9, 10).getColor should be("none")
      tui.processInputLine("load")
      cont.board.getCell(9, 10).getColor should be("black")
    }
  }
}
