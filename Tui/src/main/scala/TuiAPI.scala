import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Directives.*

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object TuiAPI :
  val tuiHost = "localhost"
  val tuiPort = 8083

  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext
  def apply() =
    val route =
      path("print") {
        put {
          Try(entity(as[String])) match {
            case Success(board) => 
              println(board)
              complete(StatusCodes.OK, "board was printed from GUI input")
            case Failure(exception) => 
              complete(StatusCodes.BadRequest, "could not print board from GUI move")
              
          }
        }
      }
    val bindingFuture = Http().newServerAt(tuiHost, tuiPort).bind(route)

