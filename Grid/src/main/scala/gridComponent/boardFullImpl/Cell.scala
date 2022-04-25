package gridComponent.boardFullImpl

import gridComponent.CellInterface

case class Cell(color: Option[String]) extends CellInterface

:
  def isOccupied: Boolean = color.isDefined

  def getColor: String = {
  color match {
  case Some (t) => t
  case None => "none"
  }
  }
end Cell
