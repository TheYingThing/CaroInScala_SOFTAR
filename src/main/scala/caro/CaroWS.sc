

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
  def getTile : Tile = tile

}

case class Grid()

val cell1 = Cell()
val redTile = Tile("red")

cell1.isOccupied
cell1.putTile(redTile)
cell1.isOccupied
cell1.getTile.getColor
