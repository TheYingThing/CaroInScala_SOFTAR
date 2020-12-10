package caro.aview

import caro.Caro
import caro.model._
import caro.controller._
import caro.aview._
import org.scalatest.matchers._
import org.scalatest.wordspec._

import java.io.ByteArrayInputStream
import scala.io.StdIn.readLine

class CaroSpec extends AnyWordSpec with should.Matchers{
  "The Caro main class" should {

    "process a text argument without reading a line" in {
      Caro.main(Array[String]("board"))
    }
  }
}
