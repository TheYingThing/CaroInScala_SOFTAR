package caro.database.slick.dataTables

import slick.jdbc.MySQLProfile.api.*

class PlayerTable(tag: Tag) extends Table[(Int, String, Int, Int, Int, Int, Int)](tag, "PLAYER"):
  
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def red = column[Int]("redTiles")
  def black = column[Int]("blackTiles")
  def grey = column[Int]("greyTiles")
  def white = column[Int]("whiteTiles")
  def points = column[Int]("points")

  
  override def * = (id, name, red, black, grey, white, points)

end PlayerTable

