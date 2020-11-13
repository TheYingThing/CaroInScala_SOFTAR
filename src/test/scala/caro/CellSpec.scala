package caro

import caro.model._

import org.scalatest._
import wordspec._
import matchers._


class CellSpec extends AnyWordSpec with should.Matchers {

  "A Cell" when {
    "no Tile set" should {
      val noTile = Cell(None)
      "have not be occupied" in {
        noTile.getTile should  be("not occupied")
      }

      "not be occupied" in {
        noTile.isOccupied should be(false)
      }
      "be able to put a new Tile" in {
        val grayTile = Tile("gray")
        val newCell = noTile.putTile(grayTile) should be (Cell(Some(Tile("gray"))))
      }
    }
    "a Tile is set" should {
      val redTile = Tile("red")
      val tileSet = Cell(Some(redTile))
      "return that Tile" in {
        tileSet.getTile should be("red")
      }
      "be occupied" in {
        tileSet.isOccupied should be(true)
      }
      "not be able to set to another Tile" in {
        val blackTile = Tile("black")
        val cellNew = tileSet.putTile(blackTile) should be(Cell(Some(Tile("red"))))
      }

    }
  }



}
