package caro.util

/**
 * Trait Command declares methods to do, redo or undo a move
 * encapsulates request as object
 *
 * @author Ying-Ling Dang
 */

trait Command:

  /**
   * methode to define step to be done
   */
  def doStep(): Unit

  /**
   * method to define step to be undone
   */
  def undoStep(): Unit

  /**
   * methode to define step to be redone
   */
  def redoStep(): Unit

end Command
