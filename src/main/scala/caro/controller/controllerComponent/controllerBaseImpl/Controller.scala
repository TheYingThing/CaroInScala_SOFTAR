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
import caro.dao.DAOInterface
import caro.dao.slick.DAOSlickImpl
import caro.database.DatabaseInterface
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.collection.immutable.ListMap
import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util
import scala.util.{Failure, Success}


class Controller @Inject()(var board: BoardInterface) extends ControllerInterface :
  private val undoManager = new UndoManager
  val injector: Injector = Guice.createInjector(new CaroModule)
  val fileIoHost: String = sys.env.getOrElse("FILEIO_HOST", "localhost").toString
  val fileIoPort: Int = sys.env.getOrElse("FILEIO_PORT", "8080").toString.toInt
  val dao:DAOInterface = injector.getInstance(classOf[DAOInterface])

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

  def saveToDB():Unit = {
    dao.create(board.board, board.width, board.height, board.moves, board.lastColor, board.status, board.player1, board.player2)
    notifyObservers()
  }

  def loadFromDB():Unit = {
    val boardDAO = dao.read()
    board = Board(boardDAO.board, boardDAO.width, boardDAO.height, boardDAO.moves, boardDAO.lastColor, boardDAO.status, boardDAO.player1, boardDAO.player2)
    notifyObservers()
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
        entity = HttpEntity(ContentTypes.`application/json`, Json.stringify(boardToJson(board)))
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
              board = loadFromString(value)
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

  def loadFromString(board: String): BoardInterface = {
    val boardJson = Json.parse(board)
    loadFromFile(boardJson)
  }

  def loadFromFile(file: JsValue): BoardInterface = {
    val moves = (file \ "board" \ "moves").get.toString.toInt
    val height = (file \ "board" \ "height").get.toString.toInt
    val width = (file \ "board" \ "width").get.toString.toInt
    val lastColor = (file \ "board" \ "lastColor").get.toString
    val status = (file \ "board" \ "status").get.toString
    val gameStatus: GameStatus = {
      status match {
        case "IDLE" => GameStatus.IDLE
        case "NOCOLORSLEFT" => GameStatus.NOCOLORSLEFT
        case "ILLEGALMOVE" => GameStatus.ILLEGALMOVE
        case "INVALIDCOLOR" => GameStatus.INVALIDCOLOR
        case _ => GameStatus.IDLE
      }
    }

    val player1val = (file \ "board" \ "player1").get.as[JsValue]
    val player2val = (file \ "board" \ "player2").get.as[JsValue]
    val player1 = loadPlayer(player1val)
    val player2 = loadPlayer(player2val)

    var board = Board(width = width, height = height, moves = moves, lastColor = lastColor, status = gameStatus,
      player1 = player1, player2 = player2)

    for
      i <- 0 until 18 * 18
    do
      val row = (file \\ "row") (i).as[Int]
      val col = (file \\ "col") (i).as[Int]
      val color = (file \\ "color") (i).as[String]
      board = board.updateCell(row, col, color)

    board
  }

  def loadPlayer(playerVal: JsValue): Player = {
    val tileVal = (playerVal \ "player") \ "tiles"
    val redVal = (tileVal \ "red").get.toString.toInt
    val blackVal = (tileVal \ "black").as[Int]
    val greyVal = (tileVal \ "grey").as[Int]
    val whiteVal = (tileVal \ "white").as[Int]

    val nameVal = ((playerVal \ "player") \ "name").get.as[String]
    val pointVal = ((playerVal \ "player") \ "points").get.toString.toInt
    val tilesVal = ListMap("red" -> redVal, "black" -> blackVal, "grey" -> greyVal, "white" -> whiteVal)
    val player = Player(name = nameVal, tiles = tilesVal, points = pointVal)

    player
  }

  def boardToJson(board: BoardInterface): JsObject = {
    Json.obj(
      "board" -> Json.obj(
        "cells" -> Json.arr(
          for
            row <- 0 until 19
            col <- 0 until 19
          yield
            Json.obj(
              "row" -> row,
              "col" -> col,
              "color" -> board.getCell(row, col).getColor,
              "isOccupied" -> board.getCell(row, col).isOccupied
            )
        ),
        "player1" -> playerToJson(board.player1),
        "player2" -> playerToJson(board.player2),
        "moves" -> board.moves,
        "lastColor" -> board.lastColor,
        "height" -> board.height,
        "width" -> board.width,
        "status" -> board.getStatusAsString))
  }

  def playerToJson(player: PlayerInterface): JsObject = {
    Json.obj(
      "player" -> Json.obj(
        "points" -> player.points,
        "name" -> player.name,
        "tiles" -> Json.obj(
          "red" -> player.tiles.get("red"),
          "black" -> player.tiles.get("black"),
          "grey" -> player.tiles.get("grey"),
          "white" -> player.tiles.get("white"))))
  }

end Controller
