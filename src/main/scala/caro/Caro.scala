package caro

import caro.aview.gui.ScalaGui
import caro.aview.*
import caro.controller.controllerComponent.ControllerInterface
import gridComponent.boardFullImpl.Board
import com.google.inject.{Guice, Injector}

import scala.io.StdIn.readLine

object Caro:
  val UICONFIG: String = System.getenv("UI_CONFIG")

  var board = new Board
  val injector: Injector = Guice.createInjector(new CaroModule)
  val controller: ControllerInterface = injector.getInstance(classOf[ControllerInterface])
  val tui = new ScalaTui(controller)

  @main def run(): Unit = {

    if UICONFIG.equals("gui") then
      val gui = new ScalaGui(controller)
      gui.update
      gui.visible = true

    println("Welcome to Caro!\n")

    print("\nCommands:"
      + "\n\t'player1|player2 <name>' - set player names"
      + "\n\t'first <Tile color>' - start with this color tile"
      + "\n\t'board' - prints current board"
      + "\n\t'put <column> <row> <Tile color> - sets tile at position"
      + "\n\t'undo' - undo most recent move"
      + "\n\t'redo' - redo most recent undo"
      + "\n\t'quit' - exit game"
      + "\n\t'save' - save current game"
      + "\n\t'load' - load saved game")

    var input: String = ""

    Thread.sleep(1000)

    while
      printf("\nEnter your command: \n")
      input = readLine()
      tui.processInputLine(input)
      input != "quit"
    do ()
  }
end Caro
