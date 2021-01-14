package caro

import caro.controller.controllerComponent.ControllerInterface
import caro.controller.controllerComponent.controllerBaseImpl._
import caro.model.fileIoComponent.FileIOInterface
import caro.model.fileIoComponent._
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl._
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule

class CaroModule extends AbstractModule with ScalaModule{

  val defaultsize: Int = 19

  override def configure() = {
    bindConstant().annotatedWith(Names.named("Defaultsize")).to(defaultsize)
    bind[BoardInterface].to[Board]
    bind[ControllerInterface].to[Controller]

    bind[BoardInterface].annotatedWithName("new").toInstance(Board())
    bind[FileIOInterface].to[fileIoJsonImpl.FileIO]
  }

}
