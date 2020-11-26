package caro.aview

import caro.controller.Controller
import caro.util.Observer


class ScalaTui(controller: Controller) extends Observer{
  controller.add(this)
  val center = 9

  def processInputLine(input: String):Unit = {
    var name1 = "player1"
    var name2 = "player2"
    input match {
      case "board" => update
      case "start" => controller.newBoard(name1, name2)
      case _ => input.split(" ").toList match {
        case first::color::Nil =>
          if (first.equals("first")) {
            controller.putCell(center, center, color)
          } else {
            update
          }
        case row::column::color::Nil => controller.putCell(row.toInt+2 , column.toInt+2, color)
        case player::name::Nil =>
          if(player.equals("player1")){
            name1 = name
          } else if(player.equals("player2")){
            name2 = name
          }
        case _ => println("Not a valid Command!")
      }
    }
  }

  override def update: Unit = println(controller.boardToString)
}

