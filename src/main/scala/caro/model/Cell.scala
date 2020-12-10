package caro.model

case class Cell(color:Option[String]) {
  def isOccupied:Boolean = color.isDefined

  def getColor: String = {
    color match {
      case Some(t) => t
      case None => "none"
    }
  }
}