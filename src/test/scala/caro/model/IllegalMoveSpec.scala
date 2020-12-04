package caro.model
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.wordspec._

class IllegalMoveSpec extends AnyWordSpec with should.Matchers{
  "An illegal move" when {
    var test = Board()
    test = test.replaceCell(9,9,"red")
    test = test.replaceCell(8,9,"black")

    val illegal = new IllegalMove()
    "moves in an even number" should {
      "take 10 points from player1" in {
        test = illegal.replacePlayer(8,8,"black", test)
        test.player1.getPoints should be(0)
      }
    }
    "moves is an uneven number" should {
      "take 10 points from player2" in {
        test = test.replaceCell(8,8,"red")
        test = illegal.replacePlayer(9,8,"red", test)
        test.player2.getPoints should be(0)
        print(test.toString)
      }
    }
    "trying to put a new cell" should {
      "return board as it is" in {
        illegal.newCell(7, 8, "red", test) should be(test)
      }
    }
    "taking points for illegal moves" should{
      "not give negative points" in{
        test = illegal.replacePlayer(10, 9, "red", test)
        test.player2.getPoints should be(0)

        test = test.replaceCell(7,9,"grey")
        test = illegal.replacePlayer(8, 10, "black", test)
        test = illegal.replacePlayer(9, 10, "red", test)
        test.player1.getPoints should be(0)

        print(test.toString)
      }
    }
  }

}
