import sbt._
import Defaults._

//addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.4.5")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")
libraryDependencies += sbtPluginExtra(
  m = "org.scoverage" % "sbt-scoverage" % "1.4.5",
  sbtV = "1.5.8",
  scalaV = "2.13.5"
)