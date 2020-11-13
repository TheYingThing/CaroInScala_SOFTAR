package caro.model


case class Board (board:Vector[Vector[Cell]] = Vector.fill(13, 13)(new Cell(None))) {
  //def this(size:Int, contents:Cell) = this(Vector.tabulate(size, size){(row, col) => contents})
  val size:Int = board.size
  def getCell(row:Int, col:Int):Cell = board (row)(col)
  def replaceCell(row:Int, col:Int, cell:Cell):Board = copy(board.updated(row, board(row).updated(col, cell)))
  override def toString: String = {
    var output = ""
    val box = " |___|"
    for (i<- 0 to 12) {
      output = output + "\n"
      for (j <- 0 to 12) {
        if (board(i)(j).getTile.equals("not occupied")) {
          output = output + box
        } else {
          output = output + " " + board(i)(j).getTile.padTo(5, ' ')

        }
      }
    }
    output
  }
}







