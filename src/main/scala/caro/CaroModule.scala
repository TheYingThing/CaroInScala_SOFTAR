package caro

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import caro.controller.controllerComponent._
import caro.model.fileIoComponent._
import caro.model.gridComponent.{BoardInterface, PlayerInterface}
import caro.model.gridComponent.boardFullImpl.{Board, Player}


class CaroModule extends AbstractModule with ScalaModule {
  override def configure():Unit = {

    bind[BoardInterface].toInstance(Board())
    bind[ControllerInterface].to[controllerBaseImpl.Controller]
    bind[FileIOInterface].to[fileIoXmlImpl.FileIO]
    //bind[FileIOInterface].to[fileIoJsonImpl.FileIO]

  }
}
