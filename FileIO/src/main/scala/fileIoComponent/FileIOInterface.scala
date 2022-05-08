package fileIoComponent

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
  def load: String

  /**
   * saves the current Board to an IO File
   * board is the board to be saved to file
   * @param board BoardInterface
   */
  def save(board: String): Unit
  
end FileIOInterface
