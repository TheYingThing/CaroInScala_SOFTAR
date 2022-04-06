package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.PlayerInterface
import com.google.inject.Inject

import scala.collection.immutable.ListMap

case class Player (override val name: String,
                   override val tiles: ListMap[String, Int] = ListMap("red" -> 3, "black" -> 3, "grey" -> 3, "white" ->3),
                   override val points: Int = 0)
  extends PlayerInterface("", ListMap.empty, 0) :

  override def toString:String = {
    var output = ""
    output = output + name + "\n"
    tiles.foreachEntry((color, number) => output = output + color + ": " + number + "\n").toString
    output = output + "Score: " + points + "\n"

    output
  }
  
end Player
