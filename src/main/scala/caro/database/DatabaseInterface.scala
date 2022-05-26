package caro.database

import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.Board

import scala.concurrent.Future


trait DatabaseInterface :

 def saveToDB(board:BoardInterface) : Unit
 
 def loadFromDB() : Future[BoardInterface]

end DatabaseInterface

