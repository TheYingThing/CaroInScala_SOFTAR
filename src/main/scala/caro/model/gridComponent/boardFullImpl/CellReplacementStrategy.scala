package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.boardFullImpl.GameStatus.*

/**
 * CellReplacementStrategy declares methods to be called when trying to replace a Cell on the current Board.
 * The methods are implemented by case classes LegalMove and IllegalMove.
 *
 * @author Ying-Ling Dang
 *         Rebecca Braun
 *
 */

trait CellReplacementStrategy :

  /**
   * newBoard updates the board after a move
   * @param row row-number as Int
   * @param col column-number as Int
   * @param color color to be placed as String
   * @param thisboard the current board as Board
   * @param status current status of the Board as ameStatus
   * @return a Board, with either a newly placed cell or a new status
   */
  def newBoard(row: Int, col: Int, color: String, thisboard: Board, status: GameStatus): Board = {
    var nboard = replacePlayer(row, col, color, thisboard, status)
    if (nboard.player1 == thisboard.player1 && nboard.player2 == thisboard.player2)
      return thisboard.copy(status = nboard.status)
    nboard = newCell(row, col, color, nboard, nboard.status)
    nboard
  }

  /**
   * replacePlayer updates the player whose turn it is
   * @param row row-number as Int
   * @param col column-number as Int
   * @param color color to be placed as String
   * @param thisboard the current Board
   * @param status the current status as GameStatus
   * @return a Boar with an updated player
   */
  def replacePlayer(row: Int, col: Int, color: String, thisboard: Board, status: GameStatus): Board

  /**
   * newCell places a new Cell on the Board
   * @param row row-number as Int
   * @param col column-number as Int
   * @param color color to be placed as String
   * @param thisboard the current Board
   * @param status tue current status of the Board
   * @return an updated Board
   */
  def newCell(row: Int, col: Int, color: String, thisboard: Board, status: GameStatus): Board

end CellReplacementStrategy
