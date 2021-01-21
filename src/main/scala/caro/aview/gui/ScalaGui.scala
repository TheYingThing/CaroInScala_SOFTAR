package caro.aview.gui


import caro.util.Observer
import caro.controller.controllerComponent._

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.{BorderFactory, ImageIcon}
import scala.swing.BorderPanel.Position._
import scala.swing._
import scala.swing.event.ButtonClicked


class ScalaGui(controller:ControllerInterface) extends Frame with Observer{
  controller.add(this)

  object player1 extends TextField{columns = 15}
  object player2 extends TextField{columns = 15}
  object accept extends Button{"accept"}
  val boardColor = new Color(100, 200, 200)


  menuBar = new MenuBar {
    contents += new Menu("Game") {
      contents += new MenuItem(Action("New") {controller.newBoard(p1 = player1.text, p2 = player2.text)})
      contents += new MenuItem(Action("Quit") {System.exit(0)})
      contents += new MenuItem(Action("Save") {controller.save})
      contents += new MenuItem(Action("Load") {controller.load})
    }
    contents += new Menu("Edit") {
      contents += new MenuItem(Action("undo") {controller.undo})
      contents += new MenuItem(Action("redo") {controller.redo})
    }
  }

  override def update: Boolean = {
    title = "Caro"
    contents = new BoardPanel(this) {
      val rules: String = ("Welcome to Caro!\n"
        + "\nRules:"
        + "\n - Same color tiles cannot be\n   placed next to each other"
        + "\n - No more than three tiles\n   of the same color diagonally"
        + "\n - No more than two neighboring\n   tiles of the same color"
        + "\n - Placed tiles cannot exceed\n   6x6 in dimensions")
      val points: String = ("Points:\n"
        + "First Tile Placed:     10pts\n"
        + "Last Tile of a color:  double pts\n"
        + "Wrong placement:     - 10pts\n"
        + "RedBlack|BlackRed:     10pts\n"
        + "RedGrey|GreyRed:       8pts\n"
        + "RedWhite|WhiteRed:     6pts\n"
        + "BlackGrey|GreyBlack:   4pts\n"
        + "BlackWhite|WhiteBlack: 2pts\n"
        + "GreyWhite|WhiteGrey:   1pts\n")
      val boardStatus = new TextArea(controller.getBoardStatus)
      boardStatus.background = new Color(0, 0, 0, 0)
      boardStatus.foreground = Color.WHITE
      val player1Stat = new TextArea(controller.playerOneToString)
      player1Stat.background = new Color(0, 0, 0, 0)
      player1Stat.foreground = Color.WHITE
      val player2Stat = new TextArea(controller.playerTwoToString)
      player2Stat.background = new Color(0, 0, 0, 0)
      player2Stat.foreground = Color.WHITE
      val ruleTxt = new TextArea(rules)
      ruleTxt.background = new Color(0, 0, 0, 0)
      ruleTxt.foreground = Color.WHITE
      val pointsTxt = new TextArea(points)
      pointsTxt.background = new Color(0, 0, 0, 0)
      pointsTxt.foreground = Color.WHITE

      val gameboard: BoxPanel = new BoxPanel(Orientation.Vertical) {
        background = new Color(0, 0, 0, 0)
        for {i <- 3 to 15} {
          contents += new BoxPanel(Orientation.Horizontal) {
            for {j <- 3 to 15}
              contents += new CellButton(i, j, controller.getCellColor(i, j),  controller)
          }
        }
      }
      val setPlayer: FlowPanel = new FlowPanel(){
        contents += player1
        contents += new Label("Player 1")
        contents += player2
        contents += new Label("Player 2")
        contents += accept
        contents += new Label("accept")
      }

      val playerStats: BoxPanel = new BoxPanel(Orientation.Vertical) {
        background = new Color(0, 0, 0, 0)
        contents += player1Stat
        player1Stat.editable = false
        player1Stat.border = BorderFactory.createEmptyBorder(30, 20, 0, 20)
        contents += player2Stat
        player2Stat.editable = false
        player2Stat.border = BorderFactory.createEmptyBorder(10, 20, 0, 20)
        if(controller.getMoves % 2 == 0) {
          player1Stat.background = new Color(255, 255, 255, 50)
          //player2Stat.background = Color.WHITE
        } else if(controller.getMoves % 2 != 0) {
          player2Stat.background = new Color(255, 255, 255, 50)
          //player1Stat.background = Color.WHITE
        }
      }

      val messageBoard: BoxPanel = new BoxPanel(Orientation.Vertical) {
        background = new Color(0, 0, 0, 0)
        contents += ruleTxt
        ruleTxt.editable = false
        ruleTxt.border = BorderFactory.createEmptyBorder(30, 20, 0, 20)
        contents += pointsTxt
        pointsTxt.editable = false
        pointsTxt.border = BorderFactory.createEmptyBorder(10, 20, 0, 20)
      }

      val gameStatus: BoxPanel = new BoxPanel(Orientation.Vertical) {
        background = new Color(0, 0, 0, 0)
        contents += boardStatus
      }
      layout(gameboard) = Center
      layout(setPlayer) = North
      layout(playerStats) = East
      layout(messageBoard) = West
      layout(gameStatus) = South
    }

    true
  }

  listenTo(accept)
  reactions += {
    case ButtonClicked(`accept`) => controller.newBoard(p1 = player1.text, p2 = player2.text)
  }
}

class BoardPanel(frame:Frame) extends BorderPanel {
  val image:BufferedImage = ImageIO.read(new File("/home/ydang/SE/CaroInScala/src/main/scala/caro/resources/wood"))
  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
    g.drawImage(image, 0, 0, frame.size.width, frame.size.height, null)
  }
}

class CellButton(row:Int, col:Int, color:String, controller: ControllerInterface)  extends Button {
  val redColor = new Color(173, 0, 0)
  val blackColor = new Color(0, 0, 0)
  val whiteColor = new Color(255, 255, 255)
  val greyColor = new Color(80, 80, 80)
  val boardColor = new Color(200, 200, 200, 0)
  var currentColor: Color = boardColor
  val s = new Dimension(60, 60)

  color match {
    case "red" => currentColor = redColor
    case "black" => currentColor = blackColor
    case "white" => currentColor = whiteColor
    case "grey" => currentColor = greyColor
    case "none" => currentColor = boardColor
  }

  val red = new RadioButton("")
  val black = new RadioButton("")
  val white = new RadioButton("")
  val grey = new RadioButton("")

  val colorbuttons: GridPanel = new GridPanel(4, 2) {
    contents += red
    contents += new Label("") {
      icon = new ImageIcon("/home/ydang/SE/CaroInScala/src/main/scala/caro/resources/redButton")
    }
    contents += black
    contents += new Label("") {
      icon = new ImageIcon("/home/ydang/SE/CaroInScala/src/main/scala/caro/resources/blackButton")
    }
    contents += white
    contents += new Label("") {
      icon = new ImageIcon("/home/ydang/SE/CaroInScala/src/main/scala/caro/resources/whiteButton")
    }
    contents += grey
    contents += new Label("") {
      icon = new ImageIcon("/home/ydang/SE/CaroInScala/src/main/scala/caro/resources/greyButton")
    }
    val colors = new ButtonGroup(red, black, white, grey)
  }

  val popupMenu: PopupMenu = new PopupMenu{
    contents += colorbuttons
  }
    if (row ==9 && col == 9) {
      text = "Go"
      font = new Font("Arial", 1, 9)
    }
  background = currentColor
  minimumSize = s
  maximumSize = s
  preferredSize = s


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
