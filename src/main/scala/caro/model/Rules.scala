package caro.model

class Rules(board:Board){
  val maxSize:Int = 6
  def getOver(row:Int, col:Int):Cell = board.getCell(row-1, col)
  def getUnder(row:Int, col:Int):Cell = board.getCell(row+1, col)
  def getLeft(row:Int, col:Int):Cell = board.getCell(row, col-1)
  def getRight(row:Int, col:Int):Cell = board.getCell(row, col+1)

  def getUpperLeft(row:Int, col:Int):Cell = board.getCell(row - 1, col - 1)
  def getUpperRight(row:Int, col:Int):Cell = board.getCell(row - 1, col + 1)
  def getLowerLeft(row:Int, col:Int):Cell = board.getCell(row + 1, col - 1)
  def getLowerRight(row:Int, col:Int):Cell = board.getCell(row + 1, col + 1)

  def allRules(row:Int, col:Int, color:String):Boolean = {
    if(board.isEmpty)
      true
    else
      sameColor(row, col, color)&&onEdge(row, col)&&diagonal(row, col, color)&&maxColor(row, col, color)&&maxField(row, col)
  }

  //returns true when tile can be laid
  def sameColor(row:Int, col:Int, color:String):Boolean = {

      if (getRight(row, col).getColor.equals(color)) {
         return false
      }
      if(getLeft(row, col).getColor.equals(color)) {
          return false
      }
      if(getOver(row, col).getColor.equals(color)) {
         return false
      }
      if(getUnder(row,col).getColor.equals(color)) {
        return false
      }

     true
  }

  //returns true when tile can be laid
  def onEdge(row:Int, col:Int):Boolean = {

     if (getRight(row, col).isOccupied)
        true
     else if(getLeft(row, col).isOccupied)
        true
     else if (getOver(row, col).isOccupied)
        true
     else if(getUnder(row, col).isOccupied)
        true
     else
       false



  }

  //returns true when tile can be laid
  def diagonal(row:Int, col:Int, color:String):Boolean ={

    var counter1:Int = 0
    var counter2:Int = 0

    if(getUpperLeft(row, col).getColor.equals(color))
      counter1 += 1
      if(getUpperLeft(row - 1, col - 1).getColor.equals(color))
        counter1 += 1
        if(getUpperLeft(row - 2, col - 2).getColor.equals(color))
          counter1 += 1

    if(getLowerRight(row, col).getColor.equals(color))
      counter1 += 1
      if(getLowerRight(row + 1, col + 1).getColor.equals(color))
        counter1 += 1
        if(getLowerRight(row + 2, col + 2).getColor.equals(color))
          counter1 += 1

    if(getUpperRight(row, col).getColor.equals(color))
      counter2 += 1
      if(getUpperRight(row -1, col + 1).getColor.equals(color))
        counter2 += 1
        if(getUpperRight(row -2, col + 2 ).getColor.equals(color))
          counter2 += 1

    if(getLowerLeft(row, col).getColor.equals(color))
      counter2 += 1
      if(getLowerLeft(row + 1, col - 1).getColor.equals(color))
        counter2 += 1
        if(getLowerLeft(row + 2, col - 2).getColor.equals(color))
          counter2 += 2

    counter1 <=2 && counter2 <= 2
  }

  //return true when tile can be laid
  def maxColor(row:Int, col:Int, color:String):Boolean = {
    twoColor(row-1, col, color)&&twoColor(row+1, col, color)&&twoColor(row, col+1, color)&&twoColor(row, col-1, color)
  }

  //return true when less than two of same color
  def twoColor(row:Int, col:Int, color:String):Boolean = {
    var counter:Int = 0
    if (getOver(row, col).getColor == color)
      counter += 1
    if (getUnder(row, col).getColor == color)
      counter += 1
    if (getLeft(row, col).getColor == color)
      counter += 1
    if (getRight(row, col).getColor == color)
      counter += 1
    counter < 2
  }

  //return true when tile can be laid
  def maxField(row:Int, col:Int):Boolean = {
    if(board.getHeight == maxSize && board.rowEmpty(row))
      return false
    if(board.getWidth == maxSize && board.colEmpty(col))
      return false
    true
  }

}
