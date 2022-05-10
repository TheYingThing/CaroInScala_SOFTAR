package caro

import caro.controller.controllerComponent.*
import caro.database.DatabaseInterface
import caro.database.slick.SlickDatabase
import fileIoComponent.*
import caro.model.gridComponent.boardFullImpl.{Board, Player}
import caro.model.gridComponent.BoardInterface
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule


class CaroModule extends AbstractModule :
  override def configure(): Unit = {

    bind(classOf[BoardInterface]).toInstance(Board())
    bind(classOf[ControllerInterface]).to(classOf[controllerBaseImpl.Controller])
//    bind(classOf[FileIOInterface]).to(classOf[fileIoXmlImpl.FileIO])
    bind(classOf[FileIOInterface]).to(classOf[fileIoJsonImpl.FileIO])
    bind(classOf[DatabaseInterface]).to(classOf[database.slick.SlickDatabase])
  }
end CaroModule
