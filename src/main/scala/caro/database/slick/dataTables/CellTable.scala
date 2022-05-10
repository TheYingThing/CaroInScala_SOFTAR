package caro.database.slick.dataTables

import slick.jdbc.MySQLProfile.api.*

class CellTable(tag: Tag) extends Table[(Int, Int, Int, String, Int)](tag, "CELLS"):

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def row = column[Int]("row")
  def col = column[Int]("col")
  def color = column[String]("color")
  def boardID = column[Int]("board_id")

  override def * = (id, row, col, color, boardID)

  def board = foreignKey("board_fk", boardID, TableQuery[BoardTable])(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  

end CellTable

