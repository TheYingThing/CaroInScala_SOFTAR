package caro.model

import org.scalatest.matchers._
import org.scalatest.wordspec._

class LegalMoveSpec extends AnyWordSpec with should.Matchers {

  "A legal move" when {
    var testBoard = Board()
    val legal = new LegalMove()
    "being an even number" should {
      "replace player1" in {
        legal.replacePlayer(9,9,"red", testBoard).player1.getPoints should be(10)

      }
    }
    "being an uneven number" should {
      "replace player2 " in {
        testBoard = testBoard.replaceCell(9, 9, "red")
        legal.replacePlayer(8, 9, "grey", testBoard).player2.getPoints should be(8)
      }
    }
    "adding a new cell" should {
      "put the new cell" in {
        legal.newCell(8,9,"grey", testBoard).getCell(8,9).getColor should be("grey")

      }
    }
  }

}