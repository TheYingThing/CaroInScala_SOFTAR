package caro.aview

import caro.model.{Board, Cell, Tile}

class ScalaTui {
  def processInputLine(input: String, board:Board): Board = {
    input match {
      case "board" => board
      case "new" => new Board
      case _ => input.split(" ").toList match {
        case row::column::color::Nil => board.replaceCell(row.toInt - 1 , column.toInt - 1, Cell(Some(Tile(color))))
        case _ => board
      }
    }
  }
}

