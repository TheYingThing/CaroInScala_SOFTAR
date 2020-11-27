package caro.aview

import caro.controller.Controller
import caro.util.Observer


class ScalaTui(controller: Controller) extends Observer{
  controller.add(this)
  val center = 9

  def processInputLine(input: String):Unit = {
    val command = input.split(" ").toList
    command.head match {
      case "board" => update
      case "start" => controller.newBoard("player1", "player2")
      case "first" => controller.putCell(center, center, command.tail.head)
      case "player1" => controller.newBoard(command.tail.head, controller.board.player2.name)
      case "player2" => controller.newBoard(controller.board.player1.name, command.tail.head)
      case "put" => {
        val cmd = command.toArray
        controller.putCell(cmd(1).toInt + 2 , cmd(2).toInt + 2, cmd(3))
      }
      case _ => println("Not a valid Command!")
    }
  }

  override def update: Unit = println(controller.boardToString)
}

