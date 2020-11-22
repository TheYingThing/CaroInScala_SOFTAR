package caro.model

import scala.collection.mutable.ListBuffer


case class Board (board:Vector[Vector[Cell]] = Vector.fill(13, 13)(Cell(None)), width:Int=0,
                  height:Int=0) {
  val maxSize:Int = 6
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
    var output = "    "
    val box = " |___|"
    for (k<- 1 to 13)
      output = output + k.toString.padTo(6, ' ')
    for (i<- 0 to 12) {
      output = output + "\n" + (i+1).toString.padTo(3, ' ')
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

  //----------------------------RULES----------------------------------------------------------------------------------
  //all return true if you can fill the cell
  def allRules(row:Int, col:Int, color:String):Boolean = {
    if(this.isEmpty)
      true
    else
      sameColor(row, col, color)&&onEdge(row, col)&&diagonal(row, col, color)&&maxColor(row, col, color)&&maxField(row, col)
  }

  def getNeighbors(row:Int, col:Int):List[Cell] = {
    getCell(row, col+1)::getCell(row, col-1)::getCell(row-1, col)::getCell(row+1, col)::Nil
  }

  def getDiagonals(row:Int, col:Int):List[List[Cell]] = {
    val r1 = row-3
    val c = col-3
    val r2 = row+3
    val buftop = ListBuffer.empty[Cell]
    val bufbottom = ListBuffer.empty[Cell]
    for(i<-0 to 6) {
      buftop += getCell(r1+i, c+i)
      bufbottom += getCell(r2-i, c+i)
    }
    var top = buftop.toList
    var bottom = bufbottom.toList
    top = top.take(3) ++ top.drop(4)
    bottom = bottom.take(3) ++ bottom.drop(4)
    top::bottom::Nil
  }

  def sameColor(row:Int, col:Int, color:String):Boolean = {
    getNeighbors(row, col).forall(n => n.getColor != color)
  }

  def onEdge(row:Int, col:Int):Boolean = {
    getNeighbors(row, col).exists(n => n.isOccupied)
  }

  def diagonal(row:Int, col:Int, color:String):Boolean = {
    val diag1 = getDiagonals(row, col)(0).sliding(3).toList
    val diag2 = getDiagonals(row, col)(1).sliding(3).toList
    val d1 = diag1.exists(l => l.forall(c => c.getColor == color)) //true when theres a sequence of 3 same colors
    val d2 = diag2.exists(l => l.forall(c => c.getColor == color))
    !(d1||d2)
  }

  def twoColor(row:Int, col:Int, color:String):Boolean = {
    val counter:Int = getNeighbors(row, col).count(n => n.getColor == color)
    counter < 2
  }

  def maxColor(row:Int, col:Int, color:String):Boolean = {
    twoColor(row-1, col, color)&&twoColor(row+1, col, color)&&twoColor(row, col+1, color)&&twoColor(row, col-1, color)
  }

  //return true when tile can be laid
  def maxField(row:Int, col:Int):Boolean = {
    if(this.getHeight == maxSize && this.rowEmpty(row))
      return false
    if(this.getWidth == maxSize && this.colEmpty(col))
      return false
    true
  }




}







