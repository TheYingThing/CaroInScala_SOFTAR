package caro.controller.controllerComponent.controllerBaseImpl

import caro.model.gridComponent.BoardInterface
import caro.util.Command
class ReplaceCommand(row:Int, col:Int, color:String, controller:Controller) extends Command {
  val oldboard:BoardInterface = controller.board
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
