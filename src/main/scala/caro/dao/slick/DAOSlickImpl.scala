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

case class DAOSlickImpl(override val board: Vector[Vector[Cell]],
                        override val width: Int,
                        override val height: Int,
                        override val moves: Int,
                        override val lastColor: String,
                        override val status: GameStatus,
                        override val player1: Player,
                        override val player2: Player)
  extends DAOInterface(
    Vector.fill(19, 19)(Cell(None)),
    0,
    0,
    0,
    "",
    GameStatus.IDLE,
    Player("player1"),
    Player("player2")) :

  val injector: Injector = Guice.createInjector(new CaroModule)
  val database: DatabaseInterface = injector.getInstance(classOf[DatabaseInterface])

  def create(): Unit = {
    database.safeToDB(this)
  }
  
  def read(): DAOInterface = {
    database.loadFromDB()
  }

/*
  def update(): Unit

  def delete(): Unit
*/


end DAOSlickImpl


