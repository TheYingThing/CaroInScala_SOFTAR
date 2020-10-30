package caro

import caro.model.Player

object Caro {
  def main(args: Array[String]): Unit = {
    println("Welcome to Caro \n")
    val student = Player("Ying and Rebecca")
    println("Hello, " + student.name + "Let's start!")
  }
}
