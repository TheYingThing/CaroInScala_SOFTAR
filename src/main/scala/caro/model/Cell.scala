package caro.model

trait Cell {
  def isOccupied:Boolean
  def getColor: String
}

private class Red extends Cell {
  override def isOccupied: Boolean = true
  override def getColor: String = "red"
}

private class Black extends Cell {
  override def isOccupied: Boolean = true
  override def getColor: String = "black"
}

private class Grey extends Cell {
  override def isOccupied: Boolean = true
  override def getColor: String = "grey"
}

private class White extends Cell {
  override def isOccupied: Boolean = true
  override def getColor: String = "white"
}

private class Empty extends Cell {
  override def isOccupied: Boolean = false
  override def getColor: String = "none"
}

object Cell {
  def apply(color: String): Cell = color match {
    case "red" => new Red()
    case "black" => new Black()
    case "grey" => new Grey()
    case "white" => new White()
    case "none" => new Empty()
  }
}