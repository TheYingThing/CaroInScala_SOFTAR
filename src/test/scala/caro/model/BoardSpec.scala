package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class BoardSpec extends AnyWordSpec with should.Matchers {

  "A Board is a two-dimensional Vector that contains Cells as the playingfield. A Board" when {
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
    "filled with " should {

      val testBoard = Board()
      val board1 = testBoard.replaceCell(2,4, "red")
      val board2 = board1.replaceCell(1,4, "black")
      val board3 = board2.replaceCell(2,5, "gray")
      val board4 = board3.replaceCell(1,3, "white")
      println("board4")
      println(board4.toString)

      "not be empty" in {
        board4.isEmpty should be(false)
      }

      "not be empty in this column" in {
        board4.colEmpty(4) should be(false)
      }

      "not be empty in this row" in {
        board4.rowEmpty(2) should be(false)
      }

      "return the Cell at index" in {
        board4.getCell(2,4).getColor should be ("red")

      }
      "have width and height set" in {
        board4.getHeight should be(2)
        board4.getWidth should be(3)
      }
      "be able to print current state as String" in {
        board4.toString should be (
          "\n |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| white black |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| red   gray  |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          " |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|")
      }
    }
  }



}

