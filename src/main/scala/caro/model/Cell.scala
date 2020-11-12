package caro.model

case class Cell(occupied:Boolean, tile:Option[Tile], left:Option[Cell],
                right:Option[Cell], up:Option[Cell], down:Option[Cell]) {

  def isOccupied: Boolean = occupied
  def putTile(t: Tile): Int = {
    if(isOccupied) {
      -1
    } else {
      copy(occupied = true, Some(t), left, right, up, down)
      0
    }
  }
  def getTile: String = {
    tile match {
      case Some(t) => t.getColor
      case None => "not occupied"
    }
  }
}

