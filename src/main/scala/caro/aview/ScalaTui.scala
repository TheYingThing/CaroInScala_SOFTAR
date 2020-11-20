package caro.aview

import caro.controller.Controller
import caro.util.Observer


class ScalaTui(controller: Controller) extends Observer{
  controller.add(this)
  val center = 6

  def processInputLine(input: String):Unit = {
    input match {
      case "board" => update
      case "new" => controller.newBoard()
      case _ => input.split(" ").toList match {
        case first::color::Nil =>
          if (first.equals("first")) {
            controller.putCell(center, center, color)
          } else {
            update
          }
        case row::column::color::Nil => controller.putCell(row.toInt - 1 , column.toInt - 1, color)
        case _ => println("Not a valid Command!")
      }
    }
  }

  override def update: Unit = println(controller.boardToString)
}

