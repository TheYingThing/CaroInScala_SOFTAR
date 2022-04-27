package caro.controller.controllerComponent

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import caro.Caro.injector

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn

object ControllerAPI {

  val host = "localhost"
  val port = 8080

  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  val controller: ControllerInterface = injector.getInstance(classOf[ControllerInterface])

  def run(): Future[Http.ServerBinding] = {
    val route: Route =
      concat(
        path("newBoard") {
          get {
            parameters("player1", "player2") {(player1, player2) =>
              controller.newBoard(player1, player2)
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>created new board</h1>"))
            }
          }
        },
        path("put") {
          get {
            parameters("row".as[Int], "col".as[Int], "color") {(row, col, color) =>
              controller.putCell(row, col, color)
              complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>put $color cell at row $row col $col</h1>"))
            }
          }
        },
        path("undo") {
          get {
            controller.undo()
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>undid last move</h1>"))
          }
        },
        path("redo") {
          get {
            controller.redo()
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>redid last move</h1>"))
          }
        },
        path("save") {
          get {
            controller.save()
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>saved current board</h1>"))
          }
        },
        path("load") {
          get {
            controller.load()
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>load saved board</h1>"))
          }
        },
        path("boardToString") {
          get {
            val board = controller.boardToString
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, board))
          }
        }
      )

    Http().newServerAt(host, port).bind(route)
  }
}
