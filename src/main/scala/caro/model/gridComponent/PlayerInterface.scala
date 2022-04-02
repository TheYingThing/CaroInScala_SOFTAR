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
trait PlayerInterface {

  /**
   * Getter for the player's points.
   * @return points as Int
   */
  def getPoints: Int

  /**
   * Getter for the remaining amount of tiles for each color that can still be placed
   * @return tiles as ListMap[String, Int]
   */
  def getTiles: ListMap[String, Int]

  /**
   * Getter for the player name
   * @return name as String
   */
  def getName: String

}