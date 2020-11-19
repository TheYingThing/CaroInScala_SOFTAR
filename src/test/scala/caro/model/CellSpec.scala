package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class CellSpec extends AnyWordSpec with should.Matchers {

  "A Cell" when {
    "no Color set" should {
      val emptyCell = Cell(None, None, None, None, None)
      "have not be occupied" in {
        emptyCell.getColor should  be("not occupied")
      }

      "not be occupied" in {
        emptyCell.isOccupied should be(false)
      }
      "be able to put a new Tile" in {
        val newCell = emptyCell.putTile("gray")
        newCell.getColor should be ("gray")
      }
    }
    "a Tile is set" should {
      val filledCell = Cell(Some("red"), None, None, None, None)
      "return that Tile" in {
        filledCell.getColor should be("red")
      }
      "be occupied" in {
        filledCell.isOccupied should be(true)
      }
      "not be able to set to another Tile" in {
        val replaceCell = filledCell.putTile("black")
        replaceCell.getColor should be ("red")
      }

    }
  }



}
