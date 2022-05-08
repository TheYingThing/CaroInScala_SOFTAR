package caro.controller.controllerComponent

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Route
import caro.Caro.injector

import scala.concurrent
import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn
import scala.util.{Success, Failure}
import scala.util.control.Exception.allCatch

object ControllerAPI {

    val host: String = System.getenv().getOrDefault("CONTROLLER_HOST", "localhost")
    val port: Int = System.getenv().getOrDefault("CONTROLLER_PORT", "8081").toInt

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
          path("boardToString") {
            get {
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.boardToString))
            }
          }
        )

      Http().newServerAt(host, port).bind(route)
    }
}