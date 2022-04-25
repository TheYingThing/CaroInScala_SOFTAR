package caro.controller.controllerComponent

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

class ControllerAPI {
  
  implicit val system: ActorSystem = ActorSystem()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  val route =
    path("newBoard") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }
  val bindingFuture = Http().newServerAt("localhost", 9001).bind(route)
}
