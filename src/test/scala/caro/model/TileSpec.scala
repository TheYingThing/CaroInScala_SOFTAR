package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._



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
