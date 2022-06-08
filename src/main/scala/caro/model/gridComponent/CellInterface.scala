package caro.model.gridComponent

/**
 * CellInterface declares methods to be implemented in the Cell case classes
 * Current implementations are :
 *
 * @see caro.model.gridComponent.boardFullImpl.Cell
 * @author Ying-Ling Dang
 *         Rebecca Braun
 */
trait CellInterface :

  /**
   * Checks if color of Cell has been set.
   *
   * @return true if color has been set, false if color is None
   */
  def isOccupied: Boolean

  /**
   * Getter for color of Cell
   *
   * @return color as String
   */
  def getColor: String

end CellInterface

