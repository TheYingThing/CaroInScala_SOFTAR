package tuiComponent

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.http.scaladsl.unmarshalling.Unmarshal

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

class ScalaTui():
  val controllerHost: String = sys.env.getOrElse("CONTROLLER_HOST", "localhost").toString
  val controllerPort: Int = sys.env.getOrElse("CONTROLLER_PORT", "8081").toString.toInt
  val center = 9

  val endpoint = s"http://$controllerHost:$controllerPort/"

  def apply(): Unit = {
  }

  def sendRequestAndPrintBoard(path: String, params: Option[String]): Unit = {
    val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "SingleRequest")
    given ActorSystem[Any] = system
    val executionContext: ExecutionContextExecutor = system.executionContext
    given ExecutionContextExecutor = executionContext
    var request = endpoint + path
    params match {
      case Some(t) =>
        request = request + t
      case None =>
    }

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(uri = request))

    responseFuture
      .onComplete {
        case Success(value) =>
          val boardAsString = Unmarshal(value.entity).to[String]
          boardAsString.onComplete {
            case Success(value) =>
              println(value)
            case Failure(exception) =>
              println("could not print board")
          }
        case Failure(exception) =>
          println("could not update board: " + exception.getMessage)
      }
  }

  def processInputLine(input: String): Unit = {
    val command = input.split(" ").toList
    command.head match {
      case "board" => sendRequestAndPrintBoard("boardToString", None)
      case "first" => sendRequestAndPrintBoard("put", Option(s"?row=${center.toString}&col=${center.toString}&color=${command.tail.head}"))
      case "player1" => sendRequestAndPrintBoard("newBoard", Option(s"?player1=${command.tail.head}&player2="))
      case "player2" => sendRequestAndPrintBoard("newBoard", Option(s"?player1=&player2=${command.tail.head}") )
      case "undo" => sendRequestAndPrintBoard("undo", None)
      case "redo" => sendRequestAndPrintBoard("redo", None)
      case "put" =>
        val cmd = command.toArray
        sendRequestAndPrintBoard("put", Option(s"?row=${(cmd(1).toInt+2).toString}&col=${(cmd(2).toInt+2).toString}&color=${cmd(3)}"))
      case "save" => sendRequestAndPrintBoard("save", None)
      case "load" => sendRequestAndPrintBoard("load", None)
      case "quit" =>
      case _ => println("Not a valid Command!")
    }
  }
end ScalaTui
