package caro

import caro.model._

object BoardTest {
  def main(args: Array[String]): Unit = {
    val redTile = Tile("red")
    val blackTile = Tile("black")
    val whiteTile = Tile("white")
    val greyTile = Tile("grey")
    val gridTest = Board()

    gridTest.board(2)(4).putTile(redTile)
    gridTest.board(1)(4).putTile(blackTile)
    gridTest.board(2)(3).putTile(whiteTile)
    gridTest.board(2)(5).putTile(whiteTile)
    gridTest.board(3)(4).putTile(greyTile)
    gridTest.board(5)(5).putTile(redTile)

    println(gridTest.toString)

  }
}