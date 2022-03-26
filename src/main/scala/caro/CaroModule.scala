package caro

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import caro.controller.controllerComponent._
import caro.model.fileIoComponent._
import caro.model.gridComponent.{BoardInterface, PlayerInterface}
import caro.model.gridComponent.boardFullImpl.{Board, Player}


class CaroModule extends AbstractModule {
  override def configure():Unit = {

    bind(classOf[BoardInterface]).toInstance(Board())
    bind(classOf[ControllerInterface]).to(classOf[controllerBaseImpl.Controller])
    bind(classOf[FileIOInterface]).to(classOf[fileIoXmlImpl.FileIO])
    //bind(classOf[FileIOInterface]).to(classOf[fileIoJsonImpl.FileIO])

  }
}
