package caro.model


case class Board (board:Vector[Vector[Cell]] = Vector.fill(13, 13)(Cell(None)), width:Int=0,
                  height:Int=0) {

  def getCell(row:Int, col:Int):Cell = board (row)(col)
  def getWidth:Int = this.width
  def getHeight:Int = this.height
  def isEmpty:Boolean = {
    !(board exists(v => v exists(c => c.isOccupied)))
  }
  def rowEmpty(row:Int):Boolean = {
    !(board(row) exists(c => c.isOccupied))
  }

  def colEmpty(col:Int):Boolean = {
    var occ = true
    for (i<-0 to 12) {
      if(getCell(i, col).isOccupied)
        occ = false
    }
    return occ
  }

  def replaceCell(row:Int, col:Int, color:String):Board = {
    val up = getCell(row-1, col)
    val down = getCell(row+1, col)
    val left = getCell(row, col-1)
    val right = getCell(row, col+1)
    if(this.getCell(row, col).getColor != color && this.getCell(row, col).isOccupied) {
      this
    } else {
      val cell = Cell(Some(color))
      var newWidth = this.getWidth
      var newHeight = this.getHeight
      if(this.isEmpty) {
        newHeight += 1
        newWidth += 1
      } else if(colEmpty(col)) {
        newWidth += 1
      } else if(rowEmpty(row)) {
        newHeight += 1
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







