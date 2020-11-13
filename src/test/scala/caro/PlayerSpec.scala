package caro

import caro.model._

import org.scalatest._
import wordspec._
import matchers._

class PlayerSpec extends AnyWordSpec with should.Matchers {

  "A Player" when {
    "being created" should {
      val player = Player("A name")
      "have a name" in {
        player.name should be("A name")
    }
      "return a String of the players name" in {
        player.toString should be("A name")
      }
    }
  }
}
