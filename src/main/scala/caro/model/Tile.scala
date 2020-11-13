package caro.model

case class Tile(c: String) {
  val color: String = c
  def getColor: String = color
}
