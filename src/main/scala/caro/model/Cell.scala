package caro.model

case class Cell() {
  var occupied: Boolean = false
  var tile: Tile = _
  var left: Tile = _
  var right: Tile = _
  var up: Tile = _
  var down: Tile = _

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

