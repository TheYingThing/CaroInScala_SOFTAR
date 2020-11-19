

case class Tile(c: String) {
  var color: String = c
  def getColor: String = color
}

val redTile = Tile("red")
val blackTile = Tile("black")
val whiteTile = Tile("white")
val grayTile = Tile("gray")

case class Cell(tile: Option[Tile]) {
  def isOccupied:Boolean = tile != None

  def putTile(t: Tile): Cell = if(!isOccupied) {
    copy(Some(t))
  } else {this}

  def getTile: String = {
    tile match {
      case Some(t) => t.getColor
      case None => "not occupied"
    }
  }
}



val cell1 = Cell(None)
cell1.isOccupied
val newCell = cell1.putTile(redTile)
newCell.isOccupied
newCell.getTile

val cell2 = newCell.putTile(blackTile)

case class Board(board:Vector[Vector[Cell]] = Vector.fill(13, 13)(Cell(None))) {
  def this(size:Int, contents:Cell) = this(Vector.tabulate(size, size){(row, col) => contents})
  val size:Int = board.size
  def getCell(row:Int, col:Int):Cell = board(row)(col)
  def replaceCell(row:Int, col:Int, cell:Cell):Board = copy(board.updated(row, board(row).updated(col, cell)))



  override def toString: String = {
    var output = ""
    val box = " |___|"
    for(i<-0 to 12) {
      output = output + "\n"
      for(j<-0 to 12) {
        if(this.getCell(i,j).getTile != "not occupied") {
          output = output + " " + this.getCell(i,j).getTile.padTo(5, ' ')
        } else {
          output = output + box
        }
      }
    }
    output
  }
}

val board = Board()



board.replaceCell(0,0, Cell(Some(redTile)))
board.getCell(0,0).getTile
board.replaceCell(0,0, Cell(Some(blackTile)))
board.getCell(0,0).getTile

board.getCell(1,1).putTile(redTile)
board.getCell(1,1).getTile
board.getCell(1,1).putTile(blackTile)
board.getCell(1,1).getTile


