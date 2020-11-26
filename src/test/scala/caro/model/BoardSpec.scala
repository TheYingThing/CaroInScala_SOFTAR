package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class BoardSpec extends AnyWordSpec with should.Matchers {

  "A Board is a two-dimensional Vector that contains Cells as the playingfield. A Board" when {

    //----------------emtpy------------------
    "empty" should {
      val emptyBoard = Board()
      "be empty" in {
        emptyBoard.isEmpty should be(true)
      }
      "have empty row" in {
        emptyBoard.rowEmpty(9) should be(true)
      }
      "have emtpy column" in {
        emptyBoard.colEmpty(9) should be(true)
      }
      "not be allowed to place a tile if it's not in the center" in {
        emptyBoard.replaceCell(4,4, "red").getCell(4, 4).getColor should be("none")
      }
      "place a tile if it's in the center" in {
        emptyBoard.replaceCell(9, 9, "black").getCell(9, 9).getColor should be("black")
      }
    }

    //---------------filled-------------------
    "filled with " should {
      var testBoard = Board()
      testBoard = testBoard.replaceCell(9,9, "red")
      testBoard  = testBoard.replaceCell(8,9, "black")
      testBoard = testBoard.replaceCell(8,8, "grey")
      testBoard = testBoard.replaceCell(7,8, "white")
      println("testBoard")
      println(testBoard.toString)
      "not be empty" in {
        testBoard.isEmpty should be(false)
      }
      "not be empty in this column" in {
        testBoard.colEmpty(9) should be(false)
      }
      "not be empty in this row" in {
        testBoard.rowEmpty(8) should be(false)
      }
      "return the Cell at index" in {
        testBoard.getCell(9,9).getColor should be ("red")
      }
      "have width and height set" in {
        testBoard.getHeight should be(3)
        testBoard.getWidth should be(2)
      }
      "be able to print current state as String" in {
        testBoard.toString should be (
          "    1     2     3     4     5     6     7     8     9     10    11    12    13    \n" +
          "1   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "2   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "3   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "4   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "5   |___| |___| |___| |___| |___| white |___| |___| |___| |___| |___| |___| |___|\n" +
          "6   |___| |___| |___| |___| |___| grey  black |___| |___| |___| |___| |___| |___|\n" +
          "7   |___| |___| |___| |___| |___| |___| red   |___| |___| |___| |___| |___| |___|\n" +
          "8   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "9   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "10  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "11  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "12  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "13  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|")
      }
    }
    "being tested for rules" should {
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



      println(board.toString)
      "return a List with two lists containing all diagonal cells without the source cell" in {
        board.getDiagonals(7, 8)(0) should be(List(Cell(None), Cell(Some("red")), Cell(Some("red")),
          Cell(None), Cell(Some("grey")), Cell(None)))
      }
      "return a List containing all the neighbouring cells" in {
        board.getNeighbors(6, 8) should be (List(Cell(Some("black")), Cell(Some("red")), Cell(None), Cell(Some("red"))))
      }
      "return false if two neighbouring cells have the same color" in {
        board.sameColor(8, 8, "red") should be(false)
      }
      "return true if they have a different color" in {
        board.sameColor(7, 7, "grey") should be(true)
      }
      "return false if a cell is not touching another cell" in {
        board.onEdge(6, 4) should be(false)
      }
      "return true if it is touching another cell" in {
        board.onEdge(5, 5) should be(true)
      }
      "check the amount of cells of the same color touching diagonally" in {
        board.diagonal(8, 9, "red") should be(false)
      }
      "return true if it is not" in {
        board.diagonal(6,8, "white") should be (true)
      }
      "return false if more than 1 cells with the same color are neighbours to the same cell " in {
        board.maxColor(5, 8, "red") should be(false)
      }
      "return true if there are less" in {
        board.maxColor(6, 11, "grey") should be(true)
      }
      "return false if two cells of the same color share a neighbour" in {
        board.twoColor(6,8, "red") should be (false)
      }
      "return true if there is only one cell of that color" in {
        board.twoColor(6,5, "grey") should be (true)
      }
      "return false is the max size of the field is already reached" in {

        board.maxField(7,11) should be (false)

      }
      "return true if not" in {
        var miniBoard = Board()
        miniBoard = miniBoard.replaceCell(4, 4, "red")
        miniBoard = miniBoard.replaceCell(4, 5, "black")

        miniBoard.maxField(4, 5) should be(true)
      }
      "check all rules at once" in {
        board.allRules(6,7, "red") should be (false)
      }
      "return true if a cell is placed in center of empty board" in {
        val newBoard = Board()
        println(newBoard.isEmpty)
        newBoard.allRules(9,9, "red") should be (true)
      }
    }
  }
}

