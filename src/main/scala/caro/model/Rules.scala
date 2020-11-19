package caro.model

class Rules(board:Board){
  val maxSize:Int = 6
  def getOver(row:Int, col:Int):Cell = board.getCell(row-1, col)
  def getUnder(row:Int, col:Int):Cell = board.getCell(row+1, col)
  def getLeft(row:Int, col:Int):Cell = board.getCell(row, col-1)
  def getRight(row:Int, col:Int):Cell = board.getCell(row, col+1)

  /*def sameColor(row:Int, col:Int, cell:Cell):Boolean = {

  }

  def onEdge(row:Int, col:Int):Boolean = {

  }

  def diagonal(row:Int, col:Int):Boolean = {

  }
*/
  def maxColor(row:Int, col:Int, cell:Cell):Boolean = {
    twoColor(row-1, col, cell)&&twoColor(row+1, col, cell)&&twoColor(row, col+1, cell)&&twoColor(row, col-1, cell)
  }

  def twoColor(row:Int, col:Int, cell:Cell):Boolean = {
    var counter:Int = 0
    if (getOver(row, col).getColor == cell.getColor)
      counter += 1
    if (getUnder(row, col).getColor == cell.getColor)
      counter += 1
    if (getLeft(row, col).getColor == cell.getColor)
      counter += 1
    if (getRight(row, col).getColor == cell.getColor)
      counter += 1
    counter >= 2
  }

  def maxField(row:Int, col:Int):Boolean = {
    if(board.getHeight == maxSize && board.rowEmpty(row))
      return true
    if(board.getWidth == maxSize && board.colEmpty(col))
      return true
    false
  }

}
