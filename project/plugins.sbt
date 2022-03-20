import sbt._
import Defaults._

//addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.4.5")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")
libraryDependencies += sbtPluginExtra(
  m = "org.scoverage" % "sbt-scoverage-plugin" % "2.0.0-M5",
  sbtV = "",
  scalaV = "2.13.8"
)