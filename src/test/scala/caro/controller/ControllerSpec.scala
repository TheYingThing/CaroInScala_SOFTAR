package caro.controller

import caro.model.Board
import caro.controller.Controller
import org.scalatest.matchers._
import org.scalatest.wordspec._

class ControllerSpec extends AnyWordSpec with should.Matchers {

  "A Controller" should {
    val board = new Board()
    val cont = new Controller(board)
    "put a first tile" in {
      cont.putCell(9, 9, "black")
      cont.board.getCell(9, 9).getColor should be("black")
    }

    "put a tile" in {
      cont.putCell(9, 10, "white")
      cont.board.getCell(9, 10).getColor should be("white")
    }

    "not put a tile" in {
      val board2 = new Board()
      val cont2 = new Controller(board2)
      cont2.putCell(13, 10, "red")
      println(cont2.boardToString)
      cont2.board.getCell(13, 10).getColor should be("none")
    }
  }

}
