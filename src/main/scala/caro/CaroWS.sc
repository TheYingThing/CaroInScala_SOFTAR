
//Ab hier aber richtig


case class Tile(c: String) {
  var color: String = c
  def getColor: String = color
}

case class Cell() {
  var occupied: Boolean = false
  var tile: Tile = null
  var left: Tile = null
  var right: Tile = null
  var up: Tile = null
  var down: Tile = null

  def getTile : Tile = tile
  def isOccupied: Boolean = occupied
  def putTile(t: Tile): Int = {
    if (isOccupied) {
      -1
    } else {
      occupied = true
      tile = t
      0
    }
  }


}

case class Grid() {
  val board =  Array.ofDim[Cell](6, 6)
  for(i<-0 to 5) {
    for(j<-0 to 5) {
      board(i)(j) = Cell()
    }
  }
}

val cell1 = Cell()
val redTile = Tile("red")
val blackTile = Tile("black")
val whiteTile = Tile("white")
val greyTile = Tile("grey")

cell1.putTile(redTile)

val gridTest = Grid()

gridTest.board(1)(2).putTile(redTile)
gridTest.board(2)(2).putTile(greyTile)
gridTest.board(4)(1).putTile(whiteTile)
gridTest.board(5)(2).putTile(blackTile)
gridTest.board(3)(4).putTile(redTile)
gridTest.board(0)(0).putTile(greyTile)
gridTest.board(1)(4).putTile(whiteTile)


val pad = 7
for(i<-0 to 5) {
  println()
  for(j<-0 to 5) {
    if(gridTest.board(i)(j).getTile != null)
      print(gridTest.board(i)(j).getTile.getColor.padTo(pad, ' ') + " ")
    else
      printf("_______ ")
  }
}

case class Board[T] (cells:Vector[Vector[T]]) {
  def this(size:Int, contents:T) = this(Vector.tabulate(size, size){(row, col) => contents})
  val size:Int = cells.size
  def getCell(row:Int, col:Int):T = cells (row)(col)
  def replaceCell(row:Int, col:Int, cell:T):Board[T] = copy(cells.updated(row, cells(row).updated(col, cell)))
  def fill(contents:T):Board[T] = copy (Vector.tabulate(size, size){(row, col) => contents})
}



case class CellFunc(occupied:Boolean, tile:Option[Tile]) {

  def isOccupied: Boolean = occupied
  def putTile(t: Tile): CellFunc = copy(occupied = true, Some(t))

  def getTile: String = {
    tile match {
      case Some(t) => t.getColor
      case None => "not occupied"
    }
  }
}

val cell2 = CellFunc(occupied = false, None)
val cell3 = CellFunc(occupied = true, tile = Some(redTile))

val testBoard = Board(Vector(Vector(cell2, cell3)))

testBoard.cells(0)(1).getTile

val originalCell = CellFunc(false, None)
originalCell.getTile

val newCell = originalCell.putTile(redTile)
newCell.getTile
