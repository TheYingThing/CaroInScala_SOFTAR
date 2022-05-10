package caro.database

import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.Board

trait DatabaseInterface :

 def safeToDB(board:BoardInterface) : Unit
 
 def loadFromDB() : Board

end DatabaseInterface

