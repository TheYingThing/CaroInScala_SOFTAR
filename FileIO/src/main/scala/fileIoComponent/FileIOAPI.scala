package fileIoComponent

import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.model.StatusCodes

import scala.io.StdIn
import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success, Try}


object FileIOAPI {

  val host = "localhost"
  val port = 8080

  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  val json = new fileIoJsonImpl.FileIO
  val xml = new fileIoXmlImpl.FileIO

  @main def run(): Unit = {

    val route = concat(
      path("fileIO" / "json" / "load") {
        get {
          Try(json.load) match {
            case Success(board) =>
              val loadData = board.toString
              complete(HttpEntity(ContentTypes.`text/xml(UTF-8)`, loadData))
            case Failure(exception) => complete(StatusCodes.BadRequest, "Board could not be loaded")
          }
        }
      },
      path("fileIO" / "json" / "save") {
        put {
          entity(as[String]) { board =>
            json.save(board)
            Try(json.load) match {
              case Success(board) => complete(StatusCodes.OK, "Board was saved")
              case Failure(exception) => complete(StatusCodes.BadRequest, "Board could not be saved")
            }
          }
        }
      },
      path("fileIO" / "xml" / "load") {
        get {
          Try(xml.load) match {
            case Success(board) =>
              val loadData = board.toString
              complete(HttpEntity(ContentTypes.`text/xml(UTF-8)`, loadData))
            case Failure(exception) => complete(StatusCodes.BadRequest, "Board could not be loaded")
          }
        }
      },
      path("fileIO" / "xml" / "save") {
        get {
          entity(as[String]) { board =>
            xml.save(board)
            Try(xml.load) match {
              case Success(board) => complete(StatusCodes.OK, "Board was saved")
              case Failure(exception) => complete(StatusCodes.BadRequest, "Board could not be saved")
            }
          }
        }
      }
    )
    val bindingFuture = Http().newServerAt(host, port).bind(route)
  }


}
