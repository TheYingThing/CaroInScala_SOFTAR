package caro.database.slick.dao

import caro.database.slick.dataTables.{CellTable, PlayerTable}
import slick.lifted.TableQuery
import slick.jdbc.MySQLProfile.api.*

import scala.language.postfixOps

class CellDAO(id: Int, row:Int, col:Int, color:Option[String], board:Int):

  def create(row:Int, col:Int, color:Option[String], board:Int, table: TableQuery[CellTable]): Unit  = {
    //Inserting into autoincrement should have no effect and work as desired
    table += (id, row, col, color, board)
  }

  def read(boardId: Int, table: TableQuery[CellTable]) : Unit = {
     table.filter(_.boardID === boardId).result
  }

end CellDAO


