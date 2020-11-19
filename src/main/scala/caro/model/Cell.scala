package caro.model

case class Cell(color:Option[String], right:Option[Cell], left:Option[Cell], up:Option[Cell], down:Option[Cell]) {
  def isOccupied:Boolean = color.isDefined

  def putTile(c: String): Cell = if(!isOccupied) {
    copy(Some(c), right, left, up, down)
  } else this

  def getColor: String = {
    color match {
      case Some(t) => t
      case None => "not occupied"
    }
  }

  def getRight: String = {
    right match {
      case Some(t) => t.getColor
      case None => "right is empty"
    }
  }

  def getLeft: String = {
    left match {
      case Some(t) => t.getColor
      case None => "left is empty"
    }
  }

  def getUp: String = {
    up match {
      case Some(t) => t.getColor
      case None => "up is empty"
    }
  }
  def getDown: String = {
    down match {
      case Some(t) => t.getColor
      case None => "down is empty"
    }
  }
}