package caro.model

case class Tile(c: String) {
  var color: String = c
  def getColor: String = color
}
