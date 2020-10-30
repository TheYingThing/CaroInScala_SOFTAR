package caro.model

case class Board() {
  val board = Array.ofDim[Cell](6, 6)
  for(i<-0 to 5; j<-0 to 5) {
    board(i)(j) = Cell()
  }

  override def toString: String = {
    var output = ""
    for(i<-0 to 5) {
      output = output + "\n"
      for(j<-0 to 5) {
        if(board(i)(j).getTile != null) {
          output = output + " " + board(i)(j).getTile.getColor.padTo(5, ' ')
        } else {
          output = output + " |___|"
        }
      }
    }
    output
  }



}
