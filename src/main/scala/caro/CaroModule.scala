package caro

import caro.controller.controllerComponent.*
import fileIoComponent.*
import gridComponent.boardFullImpl.{Board, Player}
import gridComponent.BoardInterface
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import gridComponent.BoardInterface
import net.codingwell.scalaguice.ScalaModule


class CaroModule extends AbstractModule :
  override def configure(): Unit = {

    bind(classOf[BoardInterface]).toInstance(Board())
    bind(classOf[ControllerInterface]).to(classOf[controllerBaseImpl.Controller])
//    bind(classOf[FileIOInterface]).to(classOf[fileIoXmlImpl.FileIO])
    bind(classOf[FileIOInterface]).to(classOf[fileIoJsonImpl.FileIO])
  }
end CaroModule
