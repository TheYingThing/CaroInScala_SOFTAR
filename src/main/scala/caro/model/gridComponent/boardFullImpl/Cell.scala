package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.CellInterface

case class Cell(color: Option[Color]) extends CellInterface :
  def isOccupied: Boolean = color.isDefined

  def getColor: String = {
    color match {
      case Some(t) => t.toString
      case None => "none"
    }
  }
end Cell

enum Color:
  case RED
  case BLACK
  case GREY
  case WHITE
end Color

