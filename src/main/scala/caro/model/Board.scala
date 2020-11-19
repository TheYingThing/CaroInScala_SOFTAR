package caro.model


case class Board (board:Vector[Vector[Cell]] = Vector.fill(13, 13)(Cell(None))) {
  val size:Int = board.size
  def getCell(row:Int, col:Int):Cell = board (row)(col)
  def replaceCell(row:Int, col:Int, cell:Cell):Board = {
    if (this.getCell(row,col).isOccupied) {
      print(Console.RED + "Cell is already set to another value!" + Console.BLACK)
      this
    } else {
      copy(board.updated(row, board(row).updated(col, Cell)))
    }
  }
  def getPrevious(row:Int, col:Int):Cell = this.getCell(row, col -1)
  def getNext(row:Int, col:Int):Cell = this.getCell(row, col +1)
  def getOver(row:Int, col:Int):Cell = this.getCell(row - 1, col)
  def getUnder(row:Int, col:Int):Cell = this.getCell(row + 1, col)

  def isEmpty: Boolean = {
    for ( i <- 0 to 12) {
      for (j <- 0 to 12) {
        if(this.getCell(i,j).isOccupied) {
          false
        }
      }
    }
    true
  }

  
  override def toString: String = {
    var output = ""
    val box = " |___|"
    for (i<- 0 to 12) {
      output = output + "\n"
      for(j<- 0 to 12) {
        if(this.getCell(i,j).getColor != "not occupied") {
          output = output + " " + this.getCell(i,j).getColor.padTo(5, ' ')
        } else {
          output = output + box
        }
      }
    }
    output
  }
}


