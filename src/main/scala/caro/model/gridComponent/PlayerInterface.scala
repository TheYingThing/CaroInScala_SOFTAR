package caro.model.gridComponent

import scala.collection.immutable.ListMap

/**
 * PlayerInterface declares methods to be implemented in the Player case classes
 * Current implementations are :
 *
 * @see caro.model.gridComponent.boardFullImpl.Player
 * @author Ying-Ling Dang
 *         Rebecca Braun
 */
trait PlayerInterface(val name: String,
                      val tiles: ListMap[String, Int],
                      val points: Int) :
  
end PlayerInterface
