

//Ab hier aber richtig


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

  def getTile : Tile = tile
  def isOccupied: Boolean = occupied
  def putTile(t: Tile): Int = {
    if (isOccupied) {
      -1
    } else {
      occupied = true
      tile = t
      0
    }
  }


}

case class Grid() {
  val board =  Array.ofDim[Cell](6, 6)
  for(i<-0 to 5) {
    for(j<-0 to 5) {
      board(i)(j) = Cell()
    }
  }
}

val cell1 = Cell()
val redTile = Tile("red")
val blackTile = Tile("black")
val whiteTile = Tile("white")
val greyTile = Tile("grey")

cell1.putTile(redTile)

val gridTest = Grid()

gridTest.board(1)(2).putTile(redTile)
gridTest.board(2)(2).putTile(greyTile)
gridTest.board(4)(1).putTile(whiteTile)
gridTest.board(5)(2).putTile(blackTile)
gridTest.board(3)(4).putTile(redTile)
gridTest.board(0)(0).putTile(greyTile)
gridTest.board(1)(4).putTile(whiteTile)


val pad = 7
for(i<-0 to 5) {
  println()
  for(j<-0 to 5) {
    if(gridTest.board(i)(j).getTile != null)
      print(gridTest.board(i)(j).getTile.getColor.padTo(pad, ' ') + " ")
    else
      printf("_______ ")
  }
}