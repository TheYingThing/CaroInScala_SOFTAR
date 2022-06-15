import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec
import fileIoComponent.fileIoJsonImpl.FileIO

import scala.io.Source

class FileIOSpec extends AnyWordSpec with should.Matchers:

  "A FileIO" should {
    val fileIo = FileIO()
    val board = fileIo.load

    "load a board from file" in {
      board should not be empty
    }

    "save a board to file" in {
      fileIo.save(board)
      Source.fromFile("board.json").getLines.mkString should not be null
    }
  }

end FileIOSpec



