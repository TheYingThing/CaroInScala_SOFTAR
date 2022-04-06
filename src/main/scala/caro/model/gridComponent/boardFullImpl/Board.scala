package caro.model.gridComponent.boardFullImpl

import caro.model.gridComponent.boardFullImpl.GameStatus
import caro.model.gridComponent.boardFullImpl.Rules
import caro.model.gridComponent.{BoardInterface, PlayerInterface, RulesInterface}

import javax.inject.Inject
import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

case class Board(board: Vector[Vector[Cell]] = Vector.fill(19, 19)(Cell(None)),
                 width: Int = 0,
                 height: Int = 0,
                 moves: Int = 0,
                 lastColor: String = "",
                 status: GameStatus = GameStatus.IDLE,
                 player1: Player = Player("player1"),
                 player2: Player = Player("player2"))
  extends BoardInterface(
    Vector.fill(19, 19)(Cell(None)),
    0,
    0,
    0,
    "",
    GameStatus.IDLE, 
    Player("player1"),
    Player("player2")) :

  val maxSize: Int = 6

  val rules: Rules = Rules(this)

  //---------------------GETTERS------------------------
  def getStatus: GameStatus = status

  override def getStatusMessage: String = this.status.getMessage

  def getStatusAsString: String = status.getString(this.status)

  def getLastColor: String = this.lastColor

  def getCellColor(row: Int, col: Int): String = board(row)(col).getColor

  def getCell(row: Int, col: Int): Cell = board(row)(col)

  def getWidth: Int = this.width

  def getHeight: Int = this.height

  def getPlayerOne: Player = player1

  def getPlayerTwo: Player = player2

  def getMoves: Int = moves

  def playerOneName: String = player1.name

  def playerTwoName: String = player2.name

  def playerOneAsString: String = player1.toString

  def playerTwoAsString: String = player2.toString

  //--------------------SETTERS--------------------

  /**
   * 
   * @param player Player to be set as player1
   *  @return blank board with new player1
   */
  def updatePlayerOne(player: Player): Board = copy(player1 = player)
  def updatePlayerTwo(player: Player): Board = copy(player2 = player)
  def updateCell(row: Int, col: Int, color: String): Board = {
    val newcell: Cell = if (color.equals("none")) Cell(None) else Cell(Some(color))
    copy(board.updated(row, board(row).updated(col, newcell)))
  }

  //-----------------CHECKS--------------------

  def isEmpty: Boolean = !(board exists (v => v exists (c => c.isOccupied)))
  def rowEmpty(row: Int): Boolean = !(board(row) exists (c => c.isOccupied))
  def colEmpty(col: Int): Boolean = {
    var occ = true
    (3 to 15).toList.foreach(x => {
      if board(x)(col).isOccupied then
        occ = false
    })
    occ
  }

  //----------------------BOARDFUNCTIONS------------------------------------------------------------------------------

  def validColor(color: String, player: Player): Try[Int] = Try(player.getTiles(color))
  def updatePlayer(row: Int, col: Int, color: String, player: Player): (Player, GameStatus) = {
    val oldValue: Try[Int] = validColor(color, player)
    oldValue match {
      case Success(value) =>
        if value == 0 then
          return (player, GameStatus.NOCOLORSLEFT)

        val ntiles = player.getTiles.updated(color, value - 1)
        var npoints = 0
        if this.isEmpty then
          npoints = player.points + 10
        else if ntiles(color) == 0 then
          npoints = player.points + (newPoints(row, col, color) * 2)
        else
          npoints = player.points + newPoints(row, col, color)

        (player.copy(tiles = ntiles, points = npoints), GameStatus.IDLE)

      case Failure(exception) => (player, GameStatus.INVALIDCOLOR)
    }
  }

  def updateField(int: Int, current: Int, empty: Int => Boolean): Int = {
    val currentValue = current
    val newValue = if (this.isEmpty || empty(int)) currentValue + 1 else currentValue
    newValue
  }

  def updatedWidth(col: Int): Int = updateField(col, this.width, colEmpty)
  def updatedHeight(row: Int): Int = updateField(row, this.height, rowEmpty)
  def replace(strategy: CellReplacementStrategy, status: GameStatus)(row: Int, col: Int, color: String): Board = {
    strategy.newBoard(row, col, color, this, status)
  }

  def replaceCell(row: Int, col: Int, color: String): Board = {
    val move = if(allRules(row, col, color)) replace(LegalMove(), GameStatus.IDLE)_ else replace(IllegalMove(), GameStatus.ILLEGALMOVE)_
    move(row, col, color)
  }

  override def toString: String = {
    var output = "    "
    val box = " |___|"
    val i = (3 to 15).toList

    (1 to 13).toList.foreach(x => output = output + x.toString.padTo(6, ' '))
    i.foreach(x => {
      output = output + "\n" + (x - 2).toString.padTo(3, ' ')
      i.foreach(y => {
        val color = this.board(x)(y).getColor
        output = if (color.equals("none")) output + box else output + " " + color.padTo(5, ' ')
      })
    })

    val player = if (moves % 2 == 0) player1.name else player2.name
    output = output + "\n" + player + " it's your turn!\n"
    output = output + player1.toString + "\n" + player2.toString
    output = output + this.status.getMessage
    output
  }

  //----------------------------RULES----------------------------------------------------------------------------------
  def allRules(row: Int, col: Int, color: String): Boolean = rules.allRules(row, col, color)

  //-----------------------POINTS----------------------------------------------------------------------------
  def newPoints(row: Int, col: Int, color: String): Int = {
    val combinations: Map[String, Int] = ListMap("redblack" -> 10, "blackred" -> 10, "redgrey" -> 8, "greyred" -> 8,
      "redwhite" -> 6, "whitered" -> 6, "blackgrey" -> 4, "greyblack" -> 4, "blackwhite" -> 2, "whiteblack" -> 2,
      "greywhite" -> 1, "whitegrey" -> 1).withDefaultValue(0)
    val neighbors: List[String] = rules.getNeighbors(row, col).map(c => c.getColor + color)
    var newPoints = 0
    neighbors.foreach(f => newPoints += combinations(f))
    newPoints
  }