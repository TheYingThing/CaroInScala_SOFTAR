package caro.model.gridComponent.boardFullImpl

import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

class RulesSpec extends AnyWordSpec with should.Matchers {

  "A Rule checks is a move is correct. A Rule" when {
    var board: Board =  Board()

    board = board.replaceCell(9, 9, "black")
    board = board.replaceCell(9, 10, "grey")
    board = board.replaceCell(8, 10, "red")
    board = board.replaceCell(7, 10, "black")
    board = board.replaceCell(7, 9, "grey")
    board = board.replaceCell(7, 8, "red")
    board = board.replaceCell(6, 9, "black")
    board = board.replaceCell(6, 10, "red")
    board = board.replaceCell(6, 8, "white")
    board = board.replaceCell(6, 7, "red")
    board = board.replaceCell(6, 6, "white")
    board = board.replaceCell(5, 7, "black")
    board = board.replaceCell(5, 6, "red")
    board = board.replaceCell(5, 5, "black")
    board = board.replaceCell(10, 9, "grey")

    val rules: Rules = Rules(board)


    "return a List with two lists containing all diagonal cells without the source cell" in {
      rules.getDiagonals(7, 8).head.map(c => c.getColor) should be (List("none", "red", "red",
        "none", "grey", "none"))
      rules.getDiagonals(7, 8).last.map(c => c.getColor) should be (List("none", "none", "none",
        "black", "none", "none"))
    }
    "return a List containing all the neighbouring cells" in {
      rules.getNeighbors(6, 8).map(c => c.getColor) should be (List("black", "red", "none", "red"))
    }
    "return false if two neighbouring cells have the same color" in {
      rules.sameColor(8, 8, "red") should be(false)
    }
    "return true if they have a different color" in {
      rules.sameColor(7, 7, "grey") should be(true)
    }
    "return false if a cell is not touching another cell" in {
      rules.onEdge(6, 4) should be(false)
    }
    "return true if it is touching another cell" in {
      rules.onEdge(5, 5) should be(true)
    }
    "check the amount of cells of the same color touching diagonally" in {
      rules.diagonal(8, 9, "red") should be(false)
    }
    "return true if it is not" in {
      rules.diagonal(6,8, "white") should be (true)
    }
    "return false if more than 1 cells with the same color are neighbours to the same cell " in {
      rules.maxColor(5, 8, "red") should be(false)
    }
    "return true if there are less" in {
      rules.maxColor(6, 11, "grey") should be(true)
    }
    "return false if two cells of the same color share a neighbour" in {
      rules.twoColor(6,8, "red") should be (false)
    }
    "return true if there is only one cell of that color" in {
      rules.twoColor(6,5, "grey") should be (true)
    }
    "return false if the max size of the field is already reached in this column" in {
      rules.maxField(7,11) should be (false)
    }
    "return false if the max size of the field is already reached in this row" in {
      rules.maxField(11, 9) should be (false)
    }
    "return true if not" in {
      var miniBoard = Board()
      miniBoard = miniBoard.replaceCell(4, 4, "red")
      miniBoard = miniBoard.replaceCell(4, 5, "black")

      val miniRules: Rules = Rules(miniBoard)

      miniRules.maxField(4, 5) should be(true)
    }
  }
}
