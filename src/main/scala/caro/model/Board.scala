package caro.model

class Board {

  case class Tile(c: String) {
    var color: String = c
    def getColor: String = color
  }
  case class Cell() {
    var occupied: Boolean = false
    var tile: Tile = null
    var left: Tile = null
    var right: Tile = null
    var up: Tile = null
    var down: Tile = null

    def isOccupied: Boolean = occupied
    def putTile(t: Tile): Int = {
      if(isOccupied) {
        -1
      } else {
        occupied = true
        tile = t
        0
      }
    }
    def getTile: Tile = tile

  }




  val redTile = Tile("red")
  val blackTile = Tile("black")
  val whiteTile = Tile("white")
  val greyTile = Tile("grey")

  case class Grid() {
    val board = Array.ofDim[Cell](6, 6)
    for(i<-0 to 5; j<-0 to 5)
    {
      board(i)(j) = Cell()
    }
  }

  val gridTest = Grid()

  gridTest.board(2)(4).putTile(redTile)
  gridTest.board(1)(4).putTile(blackTile)
  gridTest.board(2)(3).putTile(whiteTile)
  gridTest.board(2)(5).putTile(whiteTile)
  gridTest.board(3)(4).putTile(greyTile)
  gridTest.board(5)(5).putTile(redTile)

  for(i<-0 to 5)
  {
    println()
    for(j<-0 to 5) {
      {
        if(gridTest.board(i)(j).getTile != null) {
          print(" "+gridTest.board(i)(j).getTile.getColor.padTo(5, ' '))
        } else {
          print(" -----")
        }
      }

    }
  }

}
