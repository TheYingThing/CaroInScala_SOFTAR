package caro

import caro.controller.controllerComponent.*
import caro.model.fileIoComponent.*
import caro.model.gridComponent.boardFullImpl.{Board, Player}
import caro.model.gridComponent.{BoardInterface, PlayerInterface}
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule


class CaroModule extends AbstractModule :
  override def configure(): Unit = {

    bind(classOf[BoardInterface]).toInstance(Board())
    bind(classOf[ControllerInterface]).to(classOf[controllerBaseImpl.Controller])
//    bind(classOf[FileIOInterface]).to(classOf[fileIoXmlImpl.FileIO])
    bind(classOf[FileIOInterface]).to(classOf[fileIoJsonImpl.FileIO])
  }
end CaroModule
