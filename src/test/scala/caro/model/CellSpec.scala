package caro.model

import caro.model.gridComponent.boardFullImpl.Cell
import org.scalatest.matchers.*
import org.scalatest.wordspec.*

class CellSpec extends AnyWordSpec with should.Matchers{

  "A Cell" when {
    "no Color set" should {
      val emptyCell = Cell(None)
      "have not be occupied" in {
        emptyCell.getColor should  be("none")
      }

      "not be occupied" in {
        emptyCell.isOccupied should be(false)
      }
    }
    "a Tile is set" should {
      val filledCell = Cell(Some("red"))
      "return that Tile" in {
        filledCell.getColor should be("red")
      }
      "be occupied" in {
        filledCell.isOccupied should be(true)
      }
    }
  }
}
