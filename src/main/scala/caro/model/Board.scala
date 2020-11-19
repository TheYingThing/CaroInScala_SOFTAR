package caro.model


case class Board (board:Vector[Vector[Cell]] = Vector.fill(13, 13)(Cell(None, None, None, None, None))) {
  val size:Int = board.size
  def getCell(row:Int, col:Int):Cell = board (row)(col)
  def replaceCell(row:Int, col:Int, color:String):Board = {
    val up = getCell(row-1, col)
    val down = getCell(row+1, col)
    val left = getCell(row, col-1)
    val right = getCell(row, col+1)
    if(this.getCell(row, col).getColor != color) {
      this
    } else {
      val cell = Cell(Some(color), Some(right), Some(left), Some(up), Some(down))
      copy(board.updated(row, board(row).updated(col, cell)))
    }
  }
  //def setNeighbors(row:Int, col:Int):Board = {
  //def edgeOfBoard(cell:Cell):Boolean = {

  //}
  override def toString: String = {
    var output = ""
    val box = " |___|"
    for (i<- 0 to 12) {
      output = output + "\n"
      for (j <- 0 to 12) {
        if (this.getCell(i, j).getColor.equals("not occupied")) {
          output = output + box
        } else {
          output = output + " " + this.getCell(i, j).getColor.padTo(5, ' ')

        }
      }
    }
    output
  }
}







