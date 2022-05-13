package caro.database.slick.dataTables

import slick.jdbc.MySQLProfile.api.*

class BoardTable(tag: Tag)  extends Table[(Int, Int, Int, Int, String, String)](tag, "BOARDS"):

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def width = column[Int]("width")
  def height = column[Int]("height")
  def moves = column[Int]("moves")
  def lastColor = column[String]("lastColor")
  def status = column[String]("status")
  
  override def * = (id, width, height, moves, lastColor, status)

end BoardTable


