package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class CellSpec extends AnyWordSpec with should.Matchers {

  "A Cell" when {
    "no Color set" should {
      val emptyCell = Cell("none")
      "have not be occupied" in {
        emptyCell.getColor should  be("none")
      }

      "not be occupied" in {
        emptyCell.isOccupied should be(false)
      }
    }
    "a Tile is set" should {
      val filledCell = Cell("red")
      "return that Tile" in {
        filledCell.getColor should be("red")
      }
      "be occupied" in {
        filledCell.isOccupied should be(true)
      }
    }
  }



}
