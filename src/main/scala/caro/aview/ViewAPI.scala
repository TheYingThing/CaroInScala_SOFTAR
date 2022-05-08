package caro.aview
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import caro.controller.controllerComponent.controllerBaseImpl.Controller
import caro.controller.controllerComponent.ControllerInterface

import scala.io.StdIn
import fileIoComponent.fileIoJsonImpl.FileIO

import scala.concurrent.ExecutionContextExecutor


object ViewAPI :
  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext
  def apply() =
    val route =
      path("board") {
        get {
          complete(FileIO().load)
        }
      }
    val bindingFuture = Http().newServerAt("localhost", 8082).bind(route)

