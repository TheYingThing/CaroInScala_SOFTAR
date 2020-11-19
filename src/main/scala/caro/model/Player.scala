package caro.model


case class Player(name: String) {
  val points = 0
  val red = 3
  val black = 3
  val grey = 3
  val white = 3

  def getPoints:Int = points
  def layTile(color: String):Player = this
  override def toString:String = name
}
