package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class BoardSpec extends AnyWordSpec with should.Matchers {

  "A Board is a two-dimensional Vector that contains Cells as the playingfield. A Board" when {
    "being created" should {
      val emptyBoard = Board()
      val redCell = Cell(Some("red"), None, None, None, None)
      "be filled with empty Cells" in {

        emptyBoard.getCell(1, 1).getColor should be("not occupied")
        emptyBoard.getCell(3, 5).getColor should be("not occupied")
      }
      "have size 13" in {
        emptyBoard.size should be (13)
      }
      "be able to replace empty Cells with filled Cells and return new Board" in {
        val newBoard = emptyBoard.replaceCell(1,1, "red")
        emptyBoard.getCell(1, 1).getColor should be("not occupied")
        newBoard.getCell(1, 1).getColor should be ("red")
      }
    }
    "filled with " should {

      val testBoard = Board()

      val redTile = Tile("red")
      val blackTile = Tile("black")
      val whiteTile = Tile("white")
      val grayTile = Tile("gray")

      val board1 = testBoard.replaceCell(2,4, "red")
      val board2 = board1.replaceCell(1,4, "black")
      val board3 = board2.replaceCell(2,5, "grey")
      val board4 = board3.replaceCell(1,3, "white")

      "return the Cell at index" in {
        board4.getCell(2,4).getColor should be ("red")

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

