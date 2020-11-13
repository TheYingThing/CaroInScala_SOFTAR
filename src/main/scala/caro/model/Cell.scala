package caro.model

case class Cell(tile:Option[Tile]) {

  def putTile(t: Tile): Cell = copy(Some(t))

  def getTile: String = {
    tile match {
      case Some(t) => t.getColor
      case None => "not occupied"
    }
  }

}