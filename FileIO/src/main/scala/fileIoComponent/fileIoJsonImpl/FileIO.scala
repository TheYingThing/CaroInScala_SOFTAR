package fileIoComponent.fileIoJsonImpl

import com.google.inject.Guice
import com.google.inject.name.Names
import fileIoComponent.FileIOInterface
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector
import play.api.libs.json.JsPath.\\
import play.api.libs.json.{JsArray, JsObject, JsValue, Json, Writes}

import scala.collection.immutable.ListMap
import scala.io.{BufferedSource, Source}
import scala.language.postfixOps
import scala.xml.Elem



class FileIO extends FileIOInterface :
  override def load: String = {
    val bufferedSource: BufferedSource = Source.fromFile("board.json")
    val source: String = bufferedSource.getLines().mkString
    bufferedSource.close()
    source
  }

  override def save(board: String): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("board.json"))
    pw.write(board)
    pw.close
  }
end FileIO
