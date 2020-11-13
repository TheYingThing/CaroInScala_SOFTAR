package caro.model

case class Player(name: String) {
  var red = 3
  var black = 3
  var grey = 3
  var white = 3

  override def toString:String = name
}
