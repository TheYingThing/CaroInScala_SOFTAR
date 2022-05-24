package caro

import akka.http.scaladsl.Http
import caro.aview.gui.ScalaGui
import caro.aview.*
import caro.controller.controllerComponent.{ControllerAPI, ControllerInterface}
import com.google.inject.{Guice, Injector}
import caro.model.gridComponent.boardFullImpl.Board

import scala.concurrent.Future
import scala.io.StdIn.readLine

object Caro:
  val UICONFIG: String = System.getenv("UI_CONFIG")

  var board = new Board
  val injector: Injector = Guice.createInjector(new CaroModule)
  val controller: ControllerInterface = injector.getInstance(classOf[ControllerInterface])
  val gui = new ScalaGui(controller)

  @main def run(): Unit = {

    if UICONFIG.equals("gui") then
      gui.update
      gui.visible = true


    val controllerAPI: Unit = ControllerAPI(controller)

  }
end Caro
