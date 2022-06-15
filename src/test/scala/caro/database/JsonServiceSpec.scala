package caro.database

import caro.model.gridComponent.boardFullImpl.Board
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

import scala.language.postfixOps

class JsonServiceSpec extends AnyWordSpec with should.Matchers :

  "A jsonService" should {
    val json = JsonService
    val board = Board()
    val jsonBoard = json.boardToJson(board)
    val boardString = jsonBoard.toString

    "convert a board to json" in {
      jsonBoard should not be null
    }

    "load a board from file" in {
      val loadedBoard = json.loadFromFile(jsonBoard)
      loadedBoard should not be null
    }

    "load a board from String" in {
      val loadedBoard = json.loadFromString(boardString)
      loadedBoard should not be null
    }
  }

end JsonServiceSpec

