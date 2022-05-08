package caro.database.slick.dataTables

import slick.jdbc.MySQLProfile.api.*

class CellTable(tag: Tag) extends Table[(Int, String, Option[String])](tag, "CELLS"):

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def location = column[String]("location", O.PrimaryKey)
  def color = column[Option[String]]("color")
  def boardID = column[Int]("board_id")

  override def * = (id, location, color)
  
  def board = foreignKey("board_fk", boardID, TableQuery[BoardTable])(_.id)
  

end CellTable

