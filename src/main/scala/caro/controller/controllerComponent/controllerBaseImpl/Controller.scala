package caro.controller.controllerComponent.controllerBaseImpl

import caro.CaroModule
import caro.controller.controllerComponent.ControllerInterface
import com.google.inject.name.Named
import com.google.inject.{Guice, Inject, Injector}
import fileIoComponent.FileIOInterface
import gridComponent.boardFullImpl.Player
import gridComponent.BoardInterface
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import caro.util.UndoManager
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.unmarshalling.Unmarshal

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util
import scala.util.{Failure, Success}


class Controller @Inject()(var board: BoardInterface) extends ControllerInterface :
  private val undoManager = new UndoManager
  val injector: Injector = Guice.createInjector(new CaroModule)
  val fileIo: FileIOInterface = injector.getInstance(classOf[FileIOInterface])
  val fileIoHost: String = "localhost"
  val fileIoPort: Int = 8080

  def newBoard(p1: String, p2: String): Unit = {
    val p1Opt: Option[String] = Option(p1).filter(_.trim.nonEmpty)
    val p2Opt: Option[String] = Option(p2).filter(_.trim.nonEmpty)
    val p1Name: String = board.player1.name
    val p2Name: String = board.player2.name

    board = injector.getInstance(classOf[BoardInterface])
    p1Opt match {
      case Some(t) =>
        val nplayer1: Player = Player(t)
        val nplayer2: Player = Player(p2Name)
        board = board.updatePlayerOne(nplayer1)
        board = board.updatePlayerTwo(nplayer2)
      case None =>
    }
    p2Opt match {
      case Some(t) =>
        val nplayer1: Player = Player(p1Name)
        val nplayer2: Player = Player(t)
         board = board.updatePlayerTwo(nplayer2)
         board = board.updatePlayerOne(nplayer1)
      case None =>
    }
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

  override def save(): Unit = {
    val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "SingleRequest")
    given ActorSystem[Any] = system
    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(
      HttpRequest(
        method =  HttpMethods.PUT,
        uri = s"http://$fileIoHost:$fileIoPort/fileIO/json/save",
        entity = HttpEntity(ContentTypes.`application/json`, fileIo.boardToString(board))
      ))

    notifyObservers()
  }

  override def load(): Future[Boolean] = {
    val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "SingleRequest")
    given ActorSystem[Any] = system
    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(uri = s"http://$fileIoHost:$fileIoPort/fileIO/json/load"))

    responseFuture
      .onComplete {
        case Success(value) =>
          val boardAsString = Unmarshal(value.entity).to[String]
          boardAsString.onComplete {
            case Success(value) =>
              board = fileIo.loadFromString(value)
              notifyObservers()
              return Future(true)
            case Failure(exception) =>
              return Future(false)
          }
        case Failure(exception) =>
          return Future(false)
      }
    return Future(false)
  }

end Controller
