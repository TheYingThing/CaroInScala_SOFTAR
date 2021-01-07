package caro.aview

import caro.controller.controllerComponent.ControllerInerface
import caro.controller.controllerComponent.controllerBaseImpl.Controller
import caro.model.Player
import caro.util.Observer

class ScalaTui(controller: ControllerInerface) extends Observer{
  controller.add(this)
  val center = 9

  def processInputLine(input: String):Unit = {
    val command = input.split(" ").toList
    command.head match {
      case "board" => update
      case "first" => controller.putCell(center, center, command.tail.head)
      case "player1" => controller.newBoard(command.tail.head, controller.getPlayerTwoName)
      case "player2" => controller.newBoard(controller.getPlayerOneName, command.tail.head)
      case "undo" => controller.undo
      case "redo" => controller.redo
      case "put" =>
        val cmd = command.toArray
        controller.putCell(cmd(1).toInt + 2 , cmd(2).toInt + 2, cmd(3))
      case "correct" =>
        val cmd = command.toArray
        controller.correctCell(cmd(1).toInt + 2, cmd(2).toInt +2)

      case "quit" =>
      case _ => println("Not a valid Command!")
    }
  }

  override def update: Boolean = {
    println(controller.boardToString)
    true
  }
}

