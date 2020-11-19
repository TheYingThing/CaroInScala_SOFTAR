package caro.model


case class Board (board:Vector[Vector[Cell]] = Vector.fill(13, 13)(Cell(None)), width:Int=0,
                  height:Int=0) {

  def getCell(row:Int, col:Int):Cell = board (row)(col)
  def getWidth:Int = width
  def getHeight:Int = height
  def rowEmpty(row:Int):Boolean = {
    for(i<-0 to 12)
      return !getCell(row, i).isOccupied
    true
  }

  def colEmpty(col:Int):Boolean = {
    for (i<-0 to 12)
      return !getCell(i, col).isOccupied
    true
  }

  def replaceCell(row:Int, col:Int, color:String):Board = {
    if(this.getCell(row, col).getColor != color) {
      this
    } else {
      val cell = Cell(Some(color))
      var newWidth = 0
      var newHeight = 0
      if(rowEmpty(row)&&colEmpty(col)) {
        newHeight = 1
        newWidth = 1
      } else if(colEmpty(col)) {
        newWidth = getWidth + 1
      } else if(rowEmpty(row)) {
        newHeight = getHeight + 1
      }
      copy(board.updated(row, board(row).updated(col, cell)), width = newWidth, height = newHeight)
    }
  }

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







