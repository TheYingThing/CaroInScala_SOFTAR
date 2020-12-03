package caro.model

trait FactoryCell {
  def isOccupied:Boolean
  def getColor: String
}

private class Red extends FactoryCell {
  override def isOccupied: Boolean = true
  override def getColor: String = "red"
}

private class Black extends FactoryCell {
  override def isOccupied: Boolean = true
  override def getColor: String = "black"
}

private class Grey extends FactoryCell {
  override def isOccupied: Boolean = true
  override def getColor: String = "grey"
}

private class White extends FactoryCell {
  override def isOccupied: Boolean = true
  override def getColor: String = "white"
}

private class Empty extends FactoryCell {
  override def isOccupied: Boolean = false
  override def getColor: String = "none"
}

object FactoryCell {
  def apply(color: String): FactoryCell = color match {
    case "red" => new Red()
    case "black" => new Black()
    case "grey" => new Grey()
    case "white" => new White()
    case "none" => new Empty()
  }
}