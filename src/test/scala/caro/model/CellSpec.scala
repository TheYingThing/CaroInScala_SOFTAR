package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._


class CellSpec extends AnyWordSpec with should.Matchers {

  "A Cell" when {
    "no Tile set" should {
      val noTile = Cell(None)
      "have not be occupied" in {
        noTile.getColor should  be("not occupied")
      }

      "not be occupied" in {
        noTile.isOccupied should be(false)
      }
      "be able to put a new Tile" in {
        val newCell = noTile.putTile("grey") should be (Cell(Some("grey")))
      }
    }
    "a Tile is set" should {
      val tileSet = Cell(Some("red"))
      "return that Tile" in {
        tileSet.getColor should be("red")
      }
      "be occupied" in {
        tileSet.isOccupied should be(true)
      }
      "not be able to set to another Tile" in {
        val cellNew = tileSet.putTile("black") should be(Cell(Some("red")))
      }

    }
  }



}
