package caro.model

import scala.collection.immutable.ListMap

case class Player(name: String,
                  tiles: ListMap[String, Int] = ListMap("red" -> 3, "black" -> 3, "grey" -> 3, "white" ->3),
                  points: Int = 0) {

  def getPoints:Int = points
  def getTiles:ListMap[String, Int] = tiles
  def getName:String = name

  override def toString:String = {
    var output = ""
    output = output + name + "\n"
    tiles.foreachEntry((color, number) => output = output + color + ": " + number + "\n").toString
    output = output + "Score: " + getPoints + "\n"

    output
  }
}
