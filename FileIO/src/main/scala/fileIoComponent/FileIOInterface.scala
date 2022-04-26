package fileIoComponent

import gridComponent.BoardInterface
import scala.xml.Elem

/**
 * FileIOInterface declares methods to be implemented in the specific FileIO case classes
 * @author Ying-Ling Dang
 *         Rebecca Braun
 */

trait FileIOInterface :

  /**
   * loads a board from a saved IO File
   * @return the saved board as a BoardInterface
   */
  def load: BoardInterface

  /**
   * saves the current Board to an IO File
   * board is the board to be saved to file
   * @param board BoardInterface
   */
  def save(board: BoardInterface): Unit

  /**
   * returns the current IO Object as a String
   * @param board
   * @return
   */
  def boardToString(board: BoardInterface): String

  /**
   * loads Board from String
   * @param board
   * @return
   */
  def loadFromString(board: String): BoardInterface
  
end FileIOInterface
