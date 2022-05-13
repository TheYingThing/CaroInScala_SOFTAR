package caro.dao

import caro.model.gridComponent.boardFullImpl.{Cell, GameStatus, Player}

trait DAOInterface(val board: Vector[Vector[Cell]],
                   val width: Int,
                   val height: Int,
                   val moves: Int,
                   val lastColor: String,
                   val status: GameStatus,
                   val player1: Player,
                   val player2: Player):

  /**
   * creates a new entry in the database.
   */
  def create(): Unit

  /**
   * Reads the last Board entry in the Database.
   * @return a DAO of the last entry
   */
  def read(): DAOInterface

 /* /**
   * Updates the last board in the database.
   */
  def update(): Unit

  /**
   * Deletes the last entry in the database.
   */
  def delete(): Unit*/

end DAOInterface
