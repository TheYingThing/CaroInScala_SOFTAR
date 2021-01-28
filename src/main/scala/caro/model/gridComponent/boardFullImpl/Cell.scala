package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.CellInterface

case class Cell(color: Option[String]) extends CellInterface {
  def isOccupied: Boolean = color.isDefined

  def getColor: String = {
    color match {
      case Some(t) => t
      case None => "none"
    }
  }

  object Cell {
    import play.api.libs.json._

    implicit val cellWrites = Json.writes[Cell]
    implicit val cellReads = Json.reads[Cell]
  }
}

