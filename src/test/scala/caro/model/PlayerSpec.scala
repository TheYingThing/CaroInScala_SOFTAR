package caro.model

import caro.model.gridComponent.boardFullImpl.Player
import org.scalatest.matchers.*
import org.scalatest.wordspec.*

import scala.collection.immutable.ListMap

class PlayerSpec extends AnyWordSpec with should.Matchers :

  "A Player" when {
    "new" should {
      val player = Player("A name")
      "have a name" in {
        val player = Player("A name")
        player.name should be("A name")
    }
      "return a String of the players name" in {
        player.name should be("A name")
      }
      "return their current Score" in {
        player.points should be(0)
      }
      "return a String of their current status(points and no. of tiles)" in {
        player.toString should be("A name\nred: 3\nblack: 3\ngrey: 3\nwhite: 3\nScore: 0\n")
      }
      "return a Map with their remaining tiles" in {
        player.tiles should be(ListMap("red" -> 3, "black" -> 3, "grey" -> 3, "white" ->3))
      }
    }
  }
end PlayerSpec
