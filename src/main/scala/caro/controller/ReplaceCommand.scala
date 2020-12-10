package caro.controller

import caro.util.Command
import caro.model.Board
class ReplaceCommand(row:Int, col:Int, color:String, controller:Controller) extends Command {
  val oldboard:Board = controller.board
  override def doStep(): Unit = {
    controller.board = controller.board.replaceCell(row, col, color)
  }

  override def undoStep(): Unit = {
    controller.board = oldboard
  }

  override def redoStep(): Unit = {
    controller.board = controller.board.replaceCell(row, col, color)
  }
}
