package caro

import caro.model._

import org.scalatest._
import wordspec._
import matchers._



class TileSpec extends AnyWordSpec with should.Matchers {

  "A Tile" when  {
    "created" should {
      val blackTile = Tile("black")
      "have a color" in {
        blackTile.color should be("black")
      }
      "return the color of a Tile" in {
        blackTile.getColor should be("black")
      }
    }
  }
}
