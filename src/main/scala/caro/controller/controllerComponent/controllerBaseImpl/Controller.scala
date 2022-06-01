package caro.controller.controllerComponent.controllerBaseImpl

import caro.CaroModule
import caro.controller.controllerComponent.ControllerInterface
import com.google.inject.name.Named
import com.google.inject.{Guice, Inject, Injector}
import caro.model.gridComponent.boardFullImpl.{Board, GameStatus, Player}
import caro.model.gridComponent.{BoardInterface, PlayerInterface}
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import caro.util.UndoManager
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.unmarshalling.Unmarshal
import caro.database.DatabaseInterface
import caro.database.JsonService
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.immutable.ListMap
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor, Future}
import scala.util
import scala.util.{Failure, Success}


class Controller @Inject()(var board: BoardInterface) extends ControllerInterface :
  private val undoManager = new UndoManager
  val injector: Injector = Guice.createInjector(new CaroModule)
  val fileIoHost: String = sys.env.getOrElse("FILEIO_HOST", "127.0.0.1").toString
  val fileIoPort: Int = sys.env.getOrElse("FILEIO_PORT", "8080").toString.toInt
  val database:DatabaseInterface = injector.getInstance(classOf[DatabaseInterface])
  val jsonService = JsonService

  def newBoard(p1: String, p2: String): Unit = {
    val p1Opt: Option[String] = Option(p1).filter(_.trim.nonEmpty)
    val p2Opt: Option[String] = Option(p2).filter(_.trim.nonEmpty)

    board = injector.getInstance(classOf[BoardInterface])
    p1Opt match {
      case Some(t) =>
        val nplayer1: Player = Player(t)
        val nplayer2: Player = Player(board.player2.name)
        board = board.updatePlayerOne(nplayer1)
        board = board.updatePlayerTwo(nplayer2)
      case None =>
    }
    p2Opt match {
      case Some(t) =>
        val nplayer1: Player = Player(board.player1.name)
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

  def saveToDB():Unit = {
    database.saveToDB(board)
    notifyObservers()
  }

  def loadFromDB():Unit = {
    val loadedBoard = Await.ready(database.loadFromDB(), Duration.Inf).value.get

      loadedBoard match {
        case Success(value) =>
          println(value)
          board = value
          notifyObservers()
        case Failure(exception) =>
          println("could not load board from Database: " + exception.getMessage)
    }
  }

  override def save(): Unit = {
    val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "SingleRequest")
    given ActorSystem[Any] = system
    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(
      HttpRequest(
        method =  HttpMethods.PUT,
        uri = s"http://$fileIoHost:$fileIoPort/fileIO/json/save",
        entity = HttpEntity(ContentTypes.`application/json`, Json.stringify(jsonService.boardToJson(board)))
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
              board = jsonService.loadFromString(value)
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
