package caro.model

 class Rules(board:Board) {

  def getLeft(row:Int, col:Int):Cell = board.getCell(row, col -1)
  def getRight(row:Int, col:Int):Cell = board.getCell(row, col +1)
  def getOver(row:Int, col:Int):Cell = board.getCell(row - 1, col)
  def getUnder(row:Int, col:Int):Cell = board.getCell(row + 1, col)

  def getUpperLeft(row:Int, col:Int):Cell = board.getCell(row - 1, col - 1)
  def getUpperRight(row:Int, col:Int):Cell = board.getCell(row - 1, col + 1)
  def getLowerLeft(row:Int, col:Int):Cell = board.getCell(row + 1, col - 1)
  def getLowerRight(row:Int, col:Int):Cell = board.getCell(row + 1, col + 1)


  def sameColor(row:Int, col:Int, cell:Cell):Boolean = {

    if (getRight(row, col).isOccupied) {
      if (getRight(row, col).getColor.equals(cell.getColor)) {
        return true
      }
    } else if(getLeft(row,col).isOccupied) {
      if(getLeft(row, col).getColor.equals(cell.getColor)) {
        return true
      }
    } else if(getOver(row,col).isOccupied) {
      if(getOver(row, col).getColor.equals(cell.getColor)) {
        return true
      }
    } else if(getUnder(row,col).isOccupied) {
      if(getUnder(row,col).getColor.equals(cell.getColor)) {
        return true
      }
    }
     false
  }


  def onEdge(row:Int, col:Int):Boolean ={

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

  //def maxColor(row:Int, col:Int):Boolean = {}

  //def maxField(row:Int, col:Int):Boolean = {}



}
