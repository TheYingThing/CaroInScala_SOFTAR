package caro.model.fileIoComponent
import caro.model.gridComponent.BoardInterface

trait FileIOInterface {

  def load: BoardInterface
  def save(board:BoardInterface):Unit

}
