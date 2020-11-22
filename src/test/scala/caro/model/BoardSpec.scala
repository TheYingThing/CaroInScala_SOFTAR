package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class BoardSpec extends AnyWordSpec with should.Matchers {

  "A Board is a two-dimensional Vector that contains Cells as the playingfield. A Board" when {

    //----------------emtpy------------------
    "being created" should {
      val emptyBoard = Board()
      "be empty" in {
        emptyBoard.isEmpty should be(true)
      }
      "have empty row" in {
        emptyBoard.rowEmpty(6) should be(true)
      }
      "have emtpy column" in {
        emptyBoard.colEmpty(6) should be(true)
      }
      "be able to replace empty Cells with filled Cells and return new Board" in {
        val newBoard = emptyBoard.replaceCell(1,1, "red")
        emptyBoard.getCell(1, 1).getColor should be("not occupied")
        newBoard.getCell(1, 1).getColor should be ("red")
      }
    }

    //---------------filled-------------------
    "filled with " should {
      var testBoard = Board()
      testBoard = testBoard.replaceCell(2,4, "red")
      testBoard  = testBoard.replaceCell(1,4, "black")
      testBoard = testBoard.replaceCell(2,5, "gray")
      testBoard = testBoard.replaceCell(1,3, "white")
      println("testBoard")
      println(testBoard.toString)
      "not be empty" in {
        testBoard.isEmpty should be(false)
      }
      "not be empty in this column" in {
        testBoard.colEmpty(4) should be(false)
      }
      "not be empty in this row" in {
        testBoard.rowEmpty(2) should be(false)
      }
      "return the Cell at index" in {
        testBoard.getCell(2,4).getColor should be ("red")
      }
      "have width and height set" in {
        testBoard.getHeight should be(2)
        testBoard.getWidth should be(3)
      }
      "be able to print current state as String" in {
        testBoard.toString should be (
          "    1     2     3     4     5     6     7     8     9     10    11    12    13    \n" +
          "1   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "2   |___| |___| |___| white black |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "3   |___| |___| |___| |___| red   gray  |___| |___| |___| |___| |___| |___| |___|\n" +
          "4   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "5   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "6   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "7   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "8   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "9   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "10  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "11  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "12  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "13  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|")
      }
    }
    "being tested for rules" should {
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
      println(board14.toString)
      "return a List with two lists containing all diagonal cells without the source cell" in {

      }
      "return false if two neighbouring cells have the same color" in {
        board14.sameColor(4, 7, "black") should be(false)
      }
      "return true if they do not" in {
        board14.sameColor(4, 6, "grey") should be(true)
      }
      "return false if a cell is not touching another cell" in {
        board14.onEdge(3, 1) should be(false)
      }
      "return true if it is" in {
        board14.onEdge(2, 2) should be(true)
      }
      "check the amount of cells of the same color touching diagonally" in {
        board14.diagonal(3, 4, "red") should be(false)
      }
      "return true if it is not" in {
        board14.diagonal(3,5, "white") should be (true)
      }
      "return false if more than 2 cells with the same color are neighbours to the same cell " in {
        board14.maxColor(3, 5, "white") should be(false)
      }
      "return true if there are less" in {
        board14.maxColor(2, 3, "black") should be(true)
      }
      "return false if two cells of the same color share a neighbour" in {
        board14.twoColor(2,2, "red") should be (false)
      }
      "return true if there is only one cell of that color" in {
        board14.twoColor(2,3, "black") should be (true)
      }
      "return false is the max size of the field is already reached" in {

        board14.maxField(4,8) should be (false)
        board14.maxField(7,7) should be (false)
      }
      "return true if not" in {
        var miniBoard = Board()
        miniBoard = miniBoard.replaceCell(1, 1, "red")
        miniBoard = miniBoard.replaceCell(1, 2, "black")

        miniBoard.maxField(1, 2) should be(true)
      }
      "check all rules at once" in {
        board14.allRules(3,4, "red") should be (false)
      }
      "return true if a cell is the only one on the board" in {
        val newBoard = Board()
        println(newBoard.isEmpty)
        newBoard.allRules(2,2, "red") should be (true)
      }
    }
  }
}

