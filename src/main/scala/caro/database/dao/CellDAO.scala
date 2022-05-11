package caro.database.slick.dao

import caro.database.DatabaseInterface
import caro.database.slick.SlickDatabase
import caro.database.slick.dataTables.{CellTable, PlayerTable}
import slick.lifted.TableQuery
import slick.jdbc.MySQLProfile.api.*

import scala.language.postfixOps

class CellDAO(id: Int, row:Int, col:Int, color:Option[String], board:Int):
  val db:DatabaseInterface = new SlickDatabase()
  

end CellDAO


