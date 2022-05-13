package caro.dao.slick

import caro.CaroModule
import caro.dao.DAOInterface
import caro.database.DatabaseInterface
import caro.database.slick.SlickDatabaseImpl
import caro.database.slick.dataTables.{CellTable, PlayerTable}
import caro.model.gridComponent.boardFullImpl.{Cell, GameStatus, Player}
import com.google.inject.{Guice, Inject, Injector}
import slick.jdbc.MySQLProfile.api.*
import slick.lifted.TableQuery

import scala.language.postfixOps

case class DAOSlickImpl(override val board: Vector[Vector[Cell]] = Vector.fill(19, 19)(Cell(None)),
                        override val width: Int = 0,
                        override val height: Int = 0,
                        override val moves: Int = 0,
                        override val lastColor: String = "",
                        override val status: GameStatus = GameStatus.IDLE,
                        override val player1: Player = Player("player1"),
                        override val player2: Player = Player("player2"))
  extends DAOInterface(
    Vector.fill(19, 19)(Cell(None)),
    0,
    0,
    0,
    "",
    GameStatus.IDLE,
    Player("player1"),
    Player("player2")) :

  val database: SlickDatabaseImpl = new SlickDatabaseImpl()

  def create(boardValue: Vector[Vector[Cell]], widthValue: Int, heightValue: Int, movesValue: Int, lastColorValue: String, statusValue: GameStatus, player1Value: Player, player2Value: Player): Unit = {
    val daoToSave = DAOSlickImpl(boardValue, widthValue, heightValue, movesValue, lastColorValue, statusValue, player1Value, player2Value)
    database.safeToDB(daoToSave)
  }

  def read(): DAOInterface = {
    database.loadFromDB()
  }

  /*
    def update(): Unit

    def delete(): Unit
  */


end DAOSlickImpl


