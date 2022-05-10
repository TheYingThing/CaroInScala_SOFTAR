package caro.controller.controllerComponent

import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.Board
import caro.util.Observable

import scala.concurrent.Future

/**
 * ControllerInterface includes all methods needed to play and manage the game.
 * Controller is an instance of ControllerInterface and supervises all processes.
 * @author Ying-Ling Dang
 *         Rebecca Braun
 */

trait ControllerInterface extends Observable :

  /**
   * Method newBoard creates a new Board.
   * p1 sets name of player1
   * p2 sets name of player2
   * @param p1 String
   * @param p2 String
   */
  def newBoard(p1: String, p2: String):Unit

  /**
   * boardToString returns the current board as a String.
   * It takes no parameters.
   * @return the board as String
   */
  def boardToString:String

  /**
   * putCell places a cell on the board.
   * row gives the roe the cell is being placed in
   * col gives the column the cell is being placed in
   * color gives the color of the cell being placed
   * @param row Int
   * @param col Int
   * @param color String
   */
  def putCell(row:Int, col:Int, color:String):Unit

  /**
   * getPlayerOneName returns the name of player1
   * @return name of player1
   */
  def getPlayerOneName:String

  /**
   * getPlayerTwoName returns teh name of player2
   * @return name of player2
   */
  def getPlayerTwoName:String

  /**
   * getPlayerOneToString returns player1 as String
   * @return player1 as String
   */
  def playerOneToString:String

  /**
   * getPlayerTwoToString returns player2 as String
   * @return player2 as String
   */
  def playerTwoToString:String

  /**
   * getBoardStatus returns the current Status Message of the board
   * @return status message as String
   */
  def getBoardStatus:String

  /**
   * getCellColor gives the color of a cell
   * row gives the row the cell is located in
   * col gives the column the cell is located in
   * @param row Int
   * @param col Int
   * @return the color of the Cell at (row, col) as String
   */
  def getCellColor(row:Int, col:Int):String

  /**
   * get moves returns the number of moves made
   * @return number of moves
   */
  def getMoves:Int

  /**
   * undoes the last move made
   */
  def undo():Unit

  /**
   * redoes the last move that has been undone
   */
  def redo():Unit

  /**
   * saves the current board to a file
   */
  def save():Unit

  /**
   * loads a saved board from a file
   */
  def load():Future[Boolean]

  /**
   * saves the current board to a file
   */
  def saveToDB():Unit

  /**
   * loads a saved board from a file
   */
  def loadFromDB():Board

end ControllerInterface

