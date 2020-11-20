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
      cont.putCell(6, 6, "black")
      cont.board.getCell(6, 6).getColor should be("black")
    }

    "put a tile" in {
      cont.putCell(6, 7, "white")
      cont.board.getCell(6, 7).getColor should be("white")
    }

    "not put a tile" in {
      val board2 = new Board()
      val cont2 = new Controller(board2)
      cont2.putCell(6, 6, "black")
      cont2.putCell(10, 10, "red")
      println(cont2.boardToString)
      println(cont2.rule.onEdge(6, 6))
      cont2.board.getCell(10, 10).getColor should be("not occupied")
    }
  }

}
