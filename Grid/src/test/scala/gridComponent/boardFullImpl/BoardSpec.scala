package gridComponent.boardFullImpl

import gridComponent.boardFullImpl.*
import gridComponent.boardFullImpl.GameStatus.IDLE
import org.scalatest.matchers.*
import org.scalatest.wordspec.*

class BoardSpec extends AnyWordSpec with should.Matchers :

  "A Board is a two-dimensional Vector that contains Cells as the playingfield. A Board" when {

    //----------------emtpy------------------
    "empty" should {
      val emptyBoard = Board()
      "be empty" in {
        emptyBoard.isEmpty should be(true)
      }
      "have empty row" in {
        emptyBoard.rowEmpty(9) should be(true)
      }
      "have emtpy column" in {
        emptyBoard.colEmpty(9) should be(true)
      }
      "not be allowed to place a tile if it's not in the center" in {
        emptyBoard.replaceCell(4,4, "red").getCell(4, 4).getColor should be("none")
      }
      "place a tile if it's in the center" in {
        emptyBoard.replaceCell(9, 9, "black").getCell(9, 9).getColor should be("black")
      }
      "set a cell when loading an old game" in {
        var loadBoard = Board()
        loadBoard = loadBoard.updateCell(8, 8, "black")
        loadBoard = loadBoard.updateCell(9,9, "none")
        loadBoard.getCell(8, 8) should be (Cell(Some("black")))
        loadBoard.getCell(9,9) should be(Cell(None))
      }
    }

    //---------------filled-------------------
    "filled" should {
      var testBoard = Board()
      testBoard = testBoard.replaceCell(9,9, "red")
      testBoard  = testBoard.replaceCell(8,9, "black")
      testBoard = testBoard.replaceCell(8,8, "grey")
      testBoard = testBoard.replaceCell(7,8, "white")
      println("testBoard")
      println(testBoard.toString)
      "not be empty" in {
        testBoard.isEmpty should be(false)
      }
      "not be empty in this column" in {
        testBoard.colEmpty(9) should be(false)
      }
      "not be empty in this row" in {
        testBoard.rowEmpty(8) should be(false)
      }
      "return the Cell at index" in {
        testBoard.getCell(9,9).getColor should be ("red")
      }
      "have width and height set" in {
        testBoard.height should be(3)
        testBoard.width should be(2)
      }
      "return the current Game Status" in {
        testBoard.status should be(GameStatus.IDLE)
      }
      "return an empty String for lastColor if all moves have been legal so far" in {
        testBoard.lastColor should be ("")
      }

      "be able to print current state as String" in {
        testBoard.toString should be (
          "    1     2     3     4     5     6     7     8     9     10    11    12    13    \n" +
          "1   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "2   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "3   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "4   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "5   |___| |___| |___| |___| |___| white |___| |___| |___| |___| |___| |___| |___|\n" +
          "6   |___| |___| |___| |___| |___| grey  black |___| |___| |___| |___| |___| |___|\n" +
          "7   |___| |___| |___| |___| |___| |___| red   |___| |___| |___| |___| |___| |___|\n" +
          "8   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "9   |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "10  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "11  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "12  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "13  |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___| |___|\n" +
          "player1 it's your turn!\n" +
          "player1\nred: 2\nblack: 3\ngrey: 2\nwhite: 3\nScore: 14\n\n" +
          "player2\nred: 3\nblack: 2\ngrey: 3\nwhite: 2\nScore: 11\n")
      }
    }
    //------------------------update player----------------------------------
    "updating a player" should {
      var playerBoard = Board()
      playerBoard = playerBoard.replaceCell(9,9, "red")
      playerBoard  = playerBoard.replaceCell(8,9, "black")
      playerBoard = playerBoard.replaceCell(8,8, "grey")
      playerBoard = playerBoard.replaceCell(7,8, "white")

      "not accept pink as a valid color" in{
        playerBoard.updatePlayer(8, 7, "pink", playerBoard.player1)._1 should be(playerBoard.player1)
      }
      "accept white as a valid color" in{
        val playernew = playerBoard.updatePlayer(8, 7, "white", playerBoard.player1)._1
        println(playernew.toString)
        playernew.points should be(15)
      }
      "not have any white tiles left" in {
        var playerwhite = playerBoard.updatePlayer(8, 7, "white", playerBoard.player1)._1
        playerwhite = playerBoard.updatePlayer(10, 9, "white", playerwhite)._1
        playerwhite = playerBoard.updatePlayer(9, 10, "white", playerwhite)._1
        playerBoard.updatePlayer(11, 12, "white", playerwhite)._1 should be(playerwhite)
      }
    }
    //------------------------rules-----------------------------------------
    "being tested for rules" should {
      var board: Board =  Board()

      board = board.replaceCell(9, 9, "black")
      board = board.replaceCell(9, 10, "grey")
      board = board.replaceCell(8, 10, "red")
      board = board.replaceCell(7, 10, "black")
      board = board.replaceCell(7, 9, "grey")
      board = board.replaceCell(7, 8, "red")
      board = board.replaceCell(6, 9, "black")
      board = board.replaceCell(6, 10, "red")
      board = board.replaceCell(6, 8, "white")
      board = board.replaceCell(6, 7, "red")
      board = board.replaceCell(6, 6, "white")
      board = board.replaceCell(5, 7, "black")
      board = board.replaceCell(5, 6, "red")
      board = board.replaceCell(5, 5, "black")


      println("full board")
      println(board.toString)

      "check all rules at once" in {
        board.allRules(6,7, "red") should be (false)
      }
      "return true if a cell is placed in center of empty board" in {
        val newBoard = Board()
        println(newBoard.isEmpty)
        newBoard.allRules(9,9, "red") should be (true)
      }
    }
  }

end BoardSpec

