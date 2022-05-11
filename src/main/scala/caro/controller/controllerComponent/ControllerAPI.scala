package caro.controller.controllerComponent

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Route
import caro.Caro.injector
import fileIoComponent.FileIOAPI.system

import scala.concurrent
import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn
import scala.util.{Failure, Success}
import scala.util.control.Exception.allCatch

object ControllerAPI {

    val host: String = sys.env.getOrElse("CONTROLLER_HOST", "localhost").toString
    val port: Int = sys.env.getOrElse("CONTROLLER_PORT", "8081").toString.toInt

    val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
    given ActorSystem[Any] = system
    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext

    def apply(controller: ControllerInterface) = {
      val route: Route =
        concat(
          path("newBoard") {
            get {
              parameters("player1", "player2") {(player1, player2) =>
                controller.newBoard(player1, player2)
                complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
              }
            }
          },
          path("put") {
            get {
              parameters("row".as[Int], "col".as[Int], "color") {(row, col, color) =>
                controller.putCell(row, col, color)
                complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
              }
            }
          },
          path("undo") {
            get {
              controller.undo()
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
            }
          },
          path("redo") {
            get {
              controller.redo()
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
            }
          },
          path("save") {
            get {
              controller.save()
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
            }
          },
          path("load") {
            get {
              onComplete(controller.load()) {
                case Success(value) =>
                  complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
                case Failure(exception) => complete(StatusCodes.BadRequest, "Board could not be loaded")
              }
            }
          },
          path("saveDB") {
            get {
              controller.saveToDB()
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
            }
          },
          path("loadDB") {
            get {
              controller.loadFromDB()
              val board = controller.boardToString
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, board))
            }
          },
          path("boardToString") {
            get {
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
            }
          }
        )

      
      val bindingFuture = Http().newServerAt(host, port).bind(route)
      wait(bindingFuture)
    }
    
    def wait(bindingFuture: Future[Http.ServerBinding]): Unit = {
      StdIn.readLine() // let it run until user presses return
      bindingFuture
        .flatMap(_.unbind()) // trigger unbinding from the port
        .onComplete(_ => system.terminate()) // and shutdown when done

    }
}