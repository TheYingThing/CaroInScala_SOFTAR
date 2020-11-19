package caro.model


case class Player(name: String) {
  val red = 3
  val black = 3
  val grey = 3
  val white = 3

  override def toString:String = name
  val score:Int = 0
}
