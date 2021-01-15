package caro.controller.controllerComponent.controllerBaseImpl

import caro.CaroModule
import caro.controller.controllerComponent._
import caro.model.fileIoComponent.FileIOInterface
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.{Board, Player}
import caro.util._
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector

class Controller @Inject() (var board:BoardInterface) extends ControllerInterface {
  private val undoManager = new UndoManager
  val injector = Guice.createInjector(new CaroModule)
  val fileIo = injector.instance[FileIOInterface]
  def newBoard(p1:String, p2:String):Unit = {
    val nplayer1:Player = Player(p1)
    val nplayer2:Player = Player(p2)
    board = injector.getInstance(classOf[BoardInterface])
    board.setPlayerOne(nplayer1)
    board.setPlayerTwo(nplayer2)
    notifyObservers()
  }

  def boardToString: String = board.toString

  def putCell(row: Int, col: Int, color:String):Unit = {
    undoManager.doStep(new ReplaceCommand(row, col, color, this))
    notifyObservers()
  }

  def getPlayerOneName:String = board.getPlayerOne.getName

  def getPlayerTwoName:String = board.getPlayerTwo.getName

  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers()
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers()
  }

  override def playerOneToString: String = board.getPlayerOne.toString

  override def playerTwoToString: String = board.getPlayerTwo.toString

  override def getBoardStatus: String = board.getStatusMessage

  override def getCellColor(row: Int, col: Int): String = board.getCell(row, col).getColor

  override def getMoves: Int = board.getMoves

  def save: Unit = {
    fileIo.save(board)
    notifyObservers()
  }

  def load: Unit = {
    board = fileIo.load
    notifyObservers()
  }
}
