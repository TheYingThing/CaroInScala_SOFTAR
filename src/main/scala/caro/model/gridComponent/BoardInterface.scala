package caro.model.gridComponent

import caro.model.gridComponent.boardFullImpl.*

import scala.collection.immutable.ListMap

/**
 * BoardInterface declares methods to be implemented in the Board case classes
 * Current implementations are :
 *
 * @see caro.model.gridComponent.boardFullImpl.Board
 * @author Ying-Ling Dang
 *         Rebecca Braun
 */
trait BoardInterface(val board: Vector[Vector[Cell]],
                     val width: Int,
                     val height: Int,
                     val moves: Int,
                     val lastColor: String,
                     val status: GameStatus,
                     val player1: Player,
                     val player2: Player) {

  /**
   * getter for the status-message
   *
   * @return message of current status as String
   */
  def getStatusMessage: String

  /**
   * getter for the status as String
   * @return current status as String
   */
  def getStatusAsString: String

  /**
   * returns the Cell at the specified row and column
   *
   * @param row row-number as Int
   * @param col column-number as Int
   * @return Cell
   */

  def getCell(row: Int, col: Int): CellInterface

  /**
   * creates new blank board with player as new player1. Player2 remains unchanged.
   *
   * @param player Player to be set as player1
   * @return blank board with new player1
   */
  def updatePlayerOne(player: Player): BoardInterface

  /**
   * creates new blank board with player as new player2. Player1 remains unchanged.
   *
   * @param player Player to be set as player2
   * @return blank board with new player2
   */
  def updatePlayerTwo(player: Player): BoardInterface

  def updateCell(row: Int, col: Int, color: String): BoardInterface

  //--------------------------------CHECKS-------------------------------------------

  /**
   * checks if board contains any filled Cells
   *
   * @return true if empty
   */
  def isEmpty: Boolean

  /**
   * checks if specified row contains any filled Cells
   *
   * @param row row-number as Int
   * @return true if empty
   */
  def rowEmpty(row: Int): Boolean

  /**
   * checks if specified column contains any filled Cells
   *
   * @param col column-number as Int
   * @return true if empty
   */
  def colEmpty(col: Int): Boolean

  //------------------------------BOARD-METHODS------------------------------------------------
  /**
   * Creates new Player with updated Player-stats after a move. Returns GameStatus according
   * to type of move that was initiated.
   *
   * @param row    row-number of placed Cell as int
   * @param col    col-number of placed Cell as int
   * @param color  color of placed Cell as String
   * @param player player who executed the move as Player
   * @return tuple of updated player as PlayerInterface and respective GameStatus
   */
  def updatePlayer(row: Int, col: Int, color: String, player: Player): (PlayerInterface, GameStatus)

  /**
   * Updates the dimensions of the played field
   * @param int     row or column number as int
   * @param current current dimensions of the field as int
   * @param empty   function that checks if row or column is empty
   * @return int of new field dimension
   */
  def updateField(int: Int, current: Int, empty: Int => Boolean): Int

  /**
   * Updates the width of all currently filled Cells after a move.
   *
   * @param col column-number of placed Cell as int
   * @return new field-width as int
   */
  def updatedWidth(col: Int): Int

  /**
   * Updates the height of all currently filled Cells after a move.
   *
   * @param row row-number of placed Cell as int
   * @return new field-height as int
   */
  def updatedHeight(row: Int): Int

  /**
   * Helper method. Executes placement of a cell according to given strategy.
   *
   * @param strategy CellReplacementStrategy that is to execute
   * @param row      row-number as int
   * @param col      column-number as int
   * @param color    color to fill Cell with as String
   * @param status   GameStatus
   * @return returns BoardInterface with replaced Cell
   */
  def replace(strategy: CellReplacementStrategy, status: GameStatus)(row: Int, col: Int, color: String): BoardInterface

  /**
   * Replaces Cell at specified row and column with a new Cell of the specified color.
   * Determines a replacement strategy to execute nand calls replace().
   *
   * @param row   row-number as int
   * @param col   column-number as int
   * @param color color as String
   * @return returns BoardInterface with replaced Cell
   */
  def replaceCell(row: Int, col: Int, color: String): BoardInterface

  /**
   * Checks if the placement of a Cell of specified color into specified row and column is allowed.
   * Calls all implemented game-rules.
   *
   * @param row   row-number as int
   * @param col   column-number as int
   * @param color color as String
   * @return returns true if all rules have been honored and Cell may be placed, else false
   */
  def allRules(row: Int, col: Int, color: String): Boolean

}
