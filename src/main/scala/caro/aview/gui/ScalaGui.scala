package caro.aview.gui

import caro.controller._
import caro.util.Observer
import caro.aview.gui._

import javax.swing.Box
import scala.io.Source
import scala.swing._
import scala.swing.event.{ButtonClicked, MouseClicked}


class ScalaGui(controller:Controller) extends Frame with Observer{
  controller.add(this)

  object player1 extends TextField{columns = 15}
  object player2 extends TextField{columns = 15}
  object accept extends Button{"accept"}
  val boardColor = new Color(100, 200, 200)

  menuBar = new MenuBar {
    contents += new Menu("Game") {
      contents += new MenuItem(Action("New") {controller.newBoard(p1 = player1.text, p2 = player2.text)})
      contents += new MenuItem(Action("Quit") {System.exit(0)})
    }
    contents += new Menu("Edit") {
      contents += new MenuItem(Action("undo") {controller.undo()})
      contents += new MenuItem(Action("redo") {controller.redo()})
    }
  }

  override def update: Boolean = {
    title = "Caro"
    contents = new BoxPanel(Orientation.Vertical) {
      contents += player1
      contents += new Label("Player 1")
      contents += player2
      contents += new Label("Player 2")
      peer.add(Box.createVerticalStrut(5))
      contents += accept
      contents += new Label("Start Game")
      for {i <- 3 to 15} {
        contents += new BoxPanel(Orientation.Horizontal) {
          for {j <- 3 to 15} {
            contents += new CellButton(i, j, controller.board.getCell(i, j).getColor,  controller)
          }
        }
      }

    }
    true
  }
  listenTo(accept)
  reactions += {
    case ButtonClicked(`accept`) => controller.newBoard(p1 = player1.text, p2 = player2.text)
  }
}
class CellButton(row:Int, col:Int, color:String, controller: Controller)  extends Button {
  val redColor = new Color(173, 0, 0)
  val blackColor = new Color(0, 0, 0)
  val whiteColor = new Color(255, 255, 255)
  val greyColor = new Color(80, 80, 80)
  val boardColor = new Color(200, 200, 200)
  var currentColor = boardColor
  val s = new Dimension(60, 60)

  color match {
    case "red" => currentColor = redColor
    case "black" => currentColor = blackColor
    case "white" => currentColor = whiteColor
    case "grey" => currentColor = greyColor
    case "none" => currentColor = boardColor
  }

  val red = new RadioButton("red")
  val black = new RadioButton("black")
  val white = new RadioButton("white")
  val grey = new RadioButton("grey")


  val popupMenu = new PopupMenu{
    contents += red
    contents += black
    contents += white
    contents += grey
    val colors = new ButtonGroup(red, black, white, grey)
  }
    if (row ==9 && col == 9) {
      text = "Go"
      font = new Font("Arial", 1, 9)
    }

  background = currentColor
  minimumSize = s
  maximumSize = s
  preferredSize = s
  border = Swing.EmptyBorder


  reactions += {
    case e: ButtonClicked => popupMenu.show(this, 0, this.bounds.height)

        if(grey.selected) {
          controller.putCell(row , col, "grey")

        } else if(red.selected) {
          controller.putCell(row, col, "red")
        }
        else if(black.selected) {
          controller.putCell(row, col, "black")
        }
        else if(white.selected) {
          controller.putCell(row, col, "white")
        }

  }




}
