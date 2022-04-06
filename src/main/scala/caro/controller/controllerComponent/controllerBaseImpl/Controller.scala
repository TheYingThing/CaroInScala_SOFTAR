package caro.controller.controllerComponent.controllerBaseImpl

import caro.CaroModule
import caro.controller.controllerComponent.*
import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.{Board, Player}
import caro.util.*
import com.google.inject.name.Named
import com.google.inject.{Guice, Inject, Injector}
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector

class Controller @Inject()(var board: BoardInterface) extends ControllerInterface :
  private val undoManager = new UndoManager
  val injector: Injector = Guice.createInjector(new CaroModule)
  val fileIo: FileIOInterface = injector.getInstance(classOf[FileIOInterface])

  def newBoard(p1: String, p2: String): Unit = {
    val nplayer1: Player = Player(p1)
    val nplayer2: Player = Player(p2)
    board = injector.getInstance(classOf[BoardInterface])
    board = board.updatePlayerOne(nplayer1)
    board = board.updatePlayerTwo(nplayer2)
    notifyObservers()
  }
  
  def putCell(row: Int, col: Int, color: String): Unit = {
    undoManager.doStep(new ReplaceCommand(row, col, color, this))
    notifyObservers()
  }
  
  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers()
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers()
  }
  def boardToString: String = board.toString
  def getPlayerOneName: String = board.player1.name
  def getPlayerTwoName: String = board.player2.name
  override def playerOneToString: String = board.player1.toString
  override def playerTwoToString: String = board.player2.toString
  override def getBoardStatus: String = board.getStatusMessage
  override def getCellColor(row: Int, col: Int): String = board.getCell(row, col).getColor
  override def getMoves: Int = board.moves
  def save(): Unit = {
    fileIo.save(board)
    notifyObservers()
  }

  def load(): Unit = {
    board = fileIo.load
    notifyObservers()
  }
end Controller
