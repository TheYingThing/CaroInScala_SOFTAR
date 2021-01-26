package caro.controller.controllerComponent.controllerBaseImpl


import caro.model.gridComponent.boardFullImpl._
import org.scalatest.matchers._
import org.scalatest.wordspec._

import scala.io.Source

class ControllerSpec extends AnyWordSpec with should.Matchers {

  "A Controller" should {
    val board = Board()
    val cont = new Controller(board)

    "create a new Board empty with given names" in {
      cont.newBoard("bla","blub")
      cont.board.getPlayerOne.getName should be ("bla")
      cont.board.isEmpty should be (true)
    }

    "put a first tile" in {
      cont.putCell(9, 9, "black")
      cont.board.getCell(9, 9).getColor should be("black")
    }

    "put a tile" in {
      cont.putCell(9, 10, "white")
      cont.board.getCell(9, 10).getColor should be("white")
    }

    "not put a tile" in {
      val board2 = Board()
      val cont2 = new Controller(board2)
      cont2.putCell(13, 10, "red")
      println(cont2.boardToString)
      cont2.board.getCell(13, 10).getColor should be("none")
    }

    "correct a wrong move" in {
      cont.putCell(9, 11, "white")
      cont.board.getCell(9, 11) should be (Cell(None))

      cont.putCell(10, 9, "white")
      cont.board.getCell(10, 9).getColor should be ("white")
      cont.undo()
      cont.board.getCell(10, 9 ).getColor should be ("none")
      cont.redo()
      cont.board.getCell(10, 9).getColor should be ("white")
    }

    "return the player names" in {
      cont.getPlayerOneName should be("bla")
      cont.getPlayerTwoName should be("blub")
    }

    "return the players as strings" in {
      cont.playerOneToString should be("bla\nred: 3\nblack: 2\ngrey: 3\nwhite: 2\nScore: 2\n")
      cont.playerTwoToString should be("blub\nred: 3\nblack: 3\ngrey: 3\nwhite: 2\nScore: 2\n")
    }

    "return the board as string" in {
      cont.boardToString should be ("    1     2     3     4     5     6     7     8     9     10    11    12    13    " +
        "\n1   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n2   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n3   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n4   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n5   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n6   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n7   |___| |___| |___| |___| |___| |___| black white |___| |___| |___| |___| |___|" +
        "\n8   |___| |___| |___| |___| |___| |___| white |___| |___| |___| |___| |___| |___|" +
        "\n9   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n10  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n11  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n12  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\n13  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|" +
        "\nblub it's your turn!" +
        "\nbla" +
        "\nred: 3" +
        "\nblack: 2" +
        "\ngrey: 3" +
        "\nwhite: 2" +
        "\nScore: 2" +
        "\n\nblub" +
        "\nred: 3" +
        "\nblack: 3" +
        "\ngrey: 3" +
        "\nwhite: 2" +
        "\nScore: 2\n")
    }

    "return the GameStatus" in {
      cont.putCell(8,8,"red")
      cont.getBoardStatus should be("\nIllegal Move! Minus 10 Points!\n")
      cont.putCell(8,9, "red")
      cont.getBoardStatus should be("")
    }

    "return the color of a cell" in {
      cont.getCellColor(9,9) should be ("black")
    }

    "return the number of moves made so far" in {
      cont.getMoves should be(4)
    }

    "handle undo and redo corecctly" in {
      cont.undo()
      cont.getCellColor(8,9) should be("none")
      cont.redo()
      cont.getCellColor(8, 9) should be ("red")
    }

    "save a board" in {
      cont.save()
      scala.xml.XML.loadFile("board.xml") should not be null
      //Source.fromFile("board.json").getLines.mkString should not be null
    }

    "load a board" in {
      cont.newBoard("", "")
      cont.getCellColor(8, 9) should be("none")
      cont.load()
      cont.getCellColor(8, 9) should be("red")
    }

  }

}
