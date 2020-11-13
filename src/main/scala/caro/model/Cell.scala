package caro.model

case class Cell(tile:Option[Tile]) {
  def isOccupied:Boolean = tile.isDefined

  def putTile(t: Tile): Cell = if(!isOccupied) {
    copy(Some(t))
  } else this

  def getTile: String = {
    tile match {
      case Some(t) => t.getColor
      case None => "not occupied"
    }
  }

}