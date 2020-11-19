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

  def allRules(row:Int, col:Int, cell:Cell):Boolean = {
    return sameColor(col, row, cell) && onEdge(row, col) && diagonal(row, col, cell) && maxColor(row, col , cell)
      && maxField(row, col)

  }

  def sameColor(row:Int, col:Int, cell:Cell):Boolean = {
    if (getRight(row, col).isOccupied) {
      if (getRight(row, col).getColor.equals(cell.getColor)) {
        return false
      }
    } else if(getLeft(row,col).isOccupied) {
      if(getLeft(row, col).getColor.equals(cell.getColor)) {
        return false
      }
    } else if(getOver(row,col).isOccupied) {
      if(getOver(row, col).getColor.equals(cell.getColor)) {
        return false
      }
    } else if(getUnder(row,col).isOccupied) {
      if(getUnder(row,col).getColor.equals(cell.getColor)) {
        return false
      }
    }
     true
  }
//return true when placed next to already placed tile
  def onEdge(row:Int, col:Int):Boolean = {
     if (getRight(row, col).isOccupied) {
      return true
    } else if(getLeft(row, col).isOccupied) {
      return true
     }else if (getOver(row, col).isOccupied) {
      return true
    } else if(getUnder(row, col).isOccupied) {
      return true
    }
    false
  }
//return true when diagonal is not full
  def diagonal(row:Int, col:Int, cell:Cell):Boolean ={
    var counterDiag1:Int = 0
    var counterDiag2:Int = 0

    while (counterDiag1 < 3 && counterDiag2 < 3) {

      if(getUpperLeft(row, col).getColor.equals(cell.getColor)) {
        counterDiag1 = counterDiag1 + 1
        if(getUpperLeft(row -1, col-1).getColor.equals(cell.getColor)) {
          counterDiag1 = counterDiag1- + 1
          if(getUpperLeft(row -2, col-2 ).getColor.equals(cell.getColor)) {
            counterDiag1 = counterDiag1 + 1
          }
        }
      }

      if(getLowerRight(row, col).getColor.equals(cell.getColor)) {
        counterDiag1 = counterDiag1 + 1
        if(getLowerRight(row + 1, col + 1).getColor.equals(cell.getColor)) {
          counterDiag1 = counterDiag1 + 1
          if(getLowerRight(row + 2, col + 2).getColor.equals(cell.getColor)) {
            counterDiag1 = counterDiag1 + 1
          }
        }
      }

      if(getUpperRight(row, col).getColor.equals(cell.getColor)) {
        counterDiag2 = counterDiag2 + 1
        if(getUpperRight(row -1, col + 1).getColor.equals(cell.getColor)) {
          counterDiag2 = counterDiag2- + 1
          if(getUpperRight(row -2, col + 2 ).getColor.equals(cell.getColor)) {
            counterDiag2 = counterDiag2 + 1
          }
        }
      }
      if(getLowerLeft(row, col).getColor.equals(cell.getColor)) {
        counterDiag2 = counterDiag2 + 1
        if(getLowerLeft(row + 1, col - 1).getColor.equals(cell.getColor)) {
          counterDiag2 = counterDiag2 + 1
          if(getLowerLeft(row + 2, col - 2).getColor.equals(cell.getColor)) {
            counterDiag2 = counterDiag2 + 1
          }
        }
      }
       return true
    }
    false
  }
//returns true when tile can be laid
  def maxColor(row:Int, col:Int, cell:Cell):Boolean = {
    twoColor(row-1, col, cell)&&twoColor(row+1, col, cell)&&twoColor(row, col+1, cell)&&twoColor(row, col-1, cell)
  }
//return true when less than tow of same color
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
    counter < 2
  }
//return true when able to place new tile
  def maxField(row:Int, col:Int):Boolean = {
    if(board.getHeight == maxSize && board.rowEmpty(row))
      return false
    if(board.getWidth == maxSize && board.colEmpty(col))
      return false
    true
  }



}
