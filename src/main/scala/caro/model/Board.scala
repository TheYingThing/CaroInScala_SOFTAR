package caro.model

import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap

case class Board (board:Vector[Vector[Cell]] = Vector.fill(19, 19)(Cell(None)), width:Int=0,
                  height:Int=0, moves:Int=0, player1:Player = Player("player1"), player2:Player = Player("player2")) {
  //3-15
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
    for (i<-3 to 15) {
      if(getCell(i, col).isOccupied)
        occ = false
    }
    return occ
  }

  def updatePlayer(row:Int, col:Int, color:String, player:Player):Player = {
    val valid:Boolean = player.getTiles.keySet.contains(color)
    var oldvalue: Int = 0

    if (!valid) {
      println("Not a valid color!")
      return player
    } else {
      oldvalue = player.getTiles(color)
    }

    if(oldvalue == 0) {
      println("no tiles of this color left")
      return player
    }

    val ntiles = player.getTiles.updated(color, oldvalue-1)
    var npoints = 0
    if(this.isEmpty)
      npoints = player.getPoints + 10
    else
      npoints = player.getPoints + newPoints(row, col, color)

    player.copy(tiles = ntiles, points = npoints)

  }

  def updateWidth(col:Int):Int = {
    val currentWidth = this.getWidth
    var newWidth = 0
    if (this.isEmpty || colEmpty(col)) {
      newWidth = currentWidth +1
    } else {
      newWidth = currentWidth
    }
    newWidth
  }
  def updatedHeight(row:Int):Int = {
    val currentHeight = this.getHeight
    var newHeight = 0
    if (this.isEmpty || rowEmpty(row)) {
      newHeight = currentHeight + 1
    } else {
      newHeight = currentHeight
    }
    newHeight
  }

  def replace(strategy:CellReplacementStrategy, row:Int, col:Int, color:String, board:Board): Board = {
   strategy.newCell(row, col, color, board)
  }
  def replaceCell(row:Int, col:Int, color:String):Board = {

    if(allRules(row, col, color)){
      val legal = new LegalMove()
      replace(legal, row, col, color, this)

      /*var newPlayer1 = player1
      var newPlayer2 = player2
      if(moves%2 == 0) {
        newPlayer1 = updatePlayer(row, col, color, player1)
        if(newPlayer1 == player1)
          return this
      } else {
        newPlayer2 = updatePlayer(row, col, color, player2)
        if(newPlayer2 == player2)
          return this
      }
      val cell = Cell(Some(color))
      copy(board.updated(row, board(row).updated(col, cell)),
        width = updateWidth(col), height = updatedHeight(row), moves = this.moves + 1,
        player1 = newPlayer1, player2 = newPlayer2)
        */

    } else {
      print(row, col)
      println("illegal move, minus 10 points")
      val illegal = new IllegalMove()
      replace(illegal, row, col, color, this)
      /*
      if(moves%2 == 0) {
        copy(player1 = updatePlayer(row, col, color, player1))
      } else {
        copy(player2 = updatePlayer(row, col, color, player2))
      }*/
    }
  }

  override def toString: String = {
    var output = "    "
    val box = " |___|"
    for (k<- 1 to 13)
      output = output + k.toString.padTo(6, ' ')
    for (i<- 3 to 15) {
      output = output + "\n" + (i-2).toString.padTo(3, ' ')
      for (j <- 3 to 15) {
        if (this.getCell(i, j).getColor.equals("none")) {
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
    if(this.isEmpty && row==9 && col==9)
      true
    else
      sameColor(row, col, color)&&onEdge(row, col)&&diagonal(row, col, color)&&maxColor(row, col, color)&&maxField(row, col)&&(!getCell(row, col).isOccupied)
  }
  //rechts, links, oben, unten
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

  //returns true if theres less than two of the same color
  def twoColor(row:Int, col:Int, color:String):Boolean = {
    val counter:Int = getNeighbors(row, col).count(n => n.getColor == color)
    counter < 2
  }
  //return true when theres no neighbor that has two neighbors that are of the same color as the tile to be laid
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

//-----------------------POINTS----------------------------------------------------------------------------
  def newPoints(row:Int, col:Int, color:String):Int = {
    val combinations:Map[String, Int] = ListMap("redblack"->10, "blackred"->10, "redgrey"->8, "greyred"->8,
    "redwhite"->6, "whitered"->6, "blackgrey"->4, "greyblack"->4, "blackwhite"->2, "whiteblack"->2,
    "greywhite"->1, "whitegrey"->1).withDefaultValue(0)
    val neighbors:List[String] = this.getNeighbors(row, col).map(c => c.getColor+color)
    var newPoints = 0
    neighbors.foreach(f => newPoints += combinations(f))
    newPoints
  }


}







