package caro.model

import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._

class PlayerSpec extends AnyWordSpec with should.Matchers {

  "A Player" when {
    "new" should {
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
