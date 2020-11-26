package caro.model

case class Cell(color:Option[String]) {
  def isOccupied:Boolean = color.isDefined

  def putTile(c: String): Cell = if(!isOccupied) {
    copy(Some(c))
  } else this

  def getColor: String = {
    color match {
      case Some(t) => t
      case None => "none"
    }
  }
}