package caro

import caro.model._

import org.scalatest._
import wordspec._
import matchers._


class BoardSpec extends AnyWordSpec with should.Matchers {

  "A Board is a two-dimensional Vector that contains Cells as the playingfield. A Board" when {
    "being created" should {
      val emptyBoard = Board()
      val redTile = Tile("red")
      val cell1 = Cell(Some(redTile))
      "be filled with empty Cells" in {

        emptyBoard.board(1)(1) should be(Cell(None))
        emptyBoard.board(3)(5) should be(Cell(None))
      }
      "have size 13" in {
        emptyBoard.size should be (13)
      }
      "be able to replace empty Cells with filled Cells and return new Board" in {
        val newBoard = emptyBoard.replaceCell(1,1, cell1)
        emptyBoard.board(1)(1) should be(Cell(None))
        newBoard.board(1)(1) should be (Cell(Some(Tile("red"))))
      }
    }
    "filled with " should {

      val testBoard = Board()

      val redTile = Tile("red")
      val blackTile = Tile("black")
      val whiteTile = Tile("white")
      val grayTile = Tile("gray")

      val board1 = testBoard.replaceCell(2,4, Cell(Some(redTile)))
      val board2 = board1.replaceCell(1,4, Cell(Some(blackTile)))
      val board3 = board2.replaceCell(2,5,Cell(Some(grayTile)))
      val board4 = board3.replaceCell(1,3,Cell(Some(whiteTile)))

      "return the Cell at index" in {
        board4.getCell(2,4) should be (Cell(Some(Tile("red"))))

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

