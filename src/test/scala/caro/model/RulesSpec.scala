package caro.model

import org.scalatest.matchers._
import org.scalatest.wordspec._

class RulesSpec extends AnyWordSpec with should.Matchers {


  val board: Board =  Board()


  val board1: Board = board.replaceCell(1,2, "red")
  val board2: Board = board1.replaceCell(2,2, "black")
  val board3: Board = board2.replaceCell(4,2, "grey")
  val board4: Board = board3.replaceCell(2,3, "red")
  val board5: Board = board4.replaceCell(2,4, "white")
  val board6: Board = board5.replaceCell(3,3, "white")
  val board7: Board = board6.replaceCell(3,4, "red")
  val board8: Board = board7.replaceCell(3,5, "white")
  val board9: Board = board8.replaceCell(3,7, "black")
  val board10: Board = board9.replaceCell(4,5, "red")
  val board11: Board = board10.replaceCell(4,6, "grey")
  val board12: Board = board11.replaceCell(4,7, "black")
  val board13: Board = board12.replaceCell(5,7, "red")
  val board14: Board = board13.replaceCell(6,7, "grey")

  val rule = new Rules(board14)

  " A rule returns a boolean to check if a cell is placed correctly. It" should {
    "return false if two neighbouring cells have the same color" in {
    }
    "return true if they do not" in {
      rule.sameColor(4, 6, "grey") should be(true)
    }
    "return false if a cell is not touching another cell" in {
      rule.onEdge(3, 1) should be(false)
    }
    "return true if it is" in {
      rule.onEdge(2, 2) should be(true)
    }
    "check the amount of cells of the same color touching diagonally" in {
      rule.diagonal(3, 4, "red") should be(false)
    }
    "return true if it is not" in {
      rule.diagonal(3,5, "white") should be (true)
    }
    "return false if more than 2 cells with the same color are neighbours to the same cell " in {
      rule.maxColor(3, 5, "white") should be(false)
    }
    "return true if there are less" in {
      rule.maxColor(2, 3, "black") should be(true)
    }
    "return false if two cells of the same color share a neighbour" in {
      rule.twoColor(2,2, "red") should be (false)
    }
    "return true if there is only one cell of that color" in {
      rule.twoColor(2,3, "black") should be (true)
    }
    "return false is the max size of the field is already reached" in {

      rule.maxField(4,8) should be (false)
      rule.maxField(7,7) should be (false)
    }
    "return true if not" in {
      var testBoard = Board()
      val r = new Rules(testBoard)
      testBoard = testBoard.replaceCell(1, 1, "red")
      testBoard = testBoard.replaceCell(1, 2, "black")

      r.maxField(1, 2) should be(true)
    }
    "check all rules at once" in {
      rule.allRules(3,4, "red") should be (false)
    }
    "return true if a cell is the only one on the board" in {
      val emptyBoard = Board()
      val er = new Rules(emptyBoard)
      er.allRules(2,2, "red") should be (true)
    }
  }






}
