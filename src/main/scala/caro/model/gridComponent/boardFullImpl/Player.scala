package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.PlayerInterface
import com.google.inject.Inject

import scala.collection.immutable.ListMap

case class Player @Inject() (name: String,
                  tiles: ListMap[String, Int] = ListMap("red" -> 3, "black" -> 3, "grey" -> 3, "white" ->3),
                  points: Int = 0) extends PlayerInterface{

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

  override def setPoints(points: Int): PlayerInterface = copy(points = points)

  override def setTiles(tiles: ListMap[String, Int]): PlayerInterface = copy(tiles = tiles)

  override def setName(name: String): PlayerInterface = copy(name = name)
}
