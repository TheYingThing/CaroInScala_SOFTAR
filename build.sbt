name := "CaroInScala"

version := "0.1"
organization := "caro.sa"
scalaVersion := "3.1.1"

lazy val root = (project in file(".")).aggregate(fileIo).dependsOn(fileIo)

lazy val tui = (project in file("Tui"))
  .settings(
    name := "Tui"
  )

lazy val fileIo = (project in file("FileIO"))
  .settings(
    name := "FileIO"
  )

/*lazy val grid = (project in file("Grid"))
  .settings(
    name := "Grid"
  )*/

libraryDependencies += ("com.typesafe.akka" %% "akka-http" % "10.2.9").cross(CrossVersion.for3Use2_13)

libraryDependencies += ("com.typesafe.akka" %% "akka-actor-typed" % "2.6.19").cross(CrossVersion.for3Use2_13)

libraryDependencies += ("com.typesafe.akka" %% "akka-stream" % "2.6.19").cross(CrossVersion.for3Use2_13)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12-RC1" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"

libraryDependencies += "com.google.inject" % "guice" % "4.2.3"

libraryDependencies += ("net.codingwell" %% "scala-guice" % "5.0.2").cross(CrossVersion.for3Use2_13)

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC5"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"

libraryDependencies += ("com.typesafe.slick" %% "slick" % "3.3.3").cross(CrossVersion.for3Use2_13)

libraryDependencies += ("com.typesafe.slick" %% "slick-hikaricp" % "3.3.3").cross(CrossVersion.for3Use2_13)

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.29"

libraryDependencies += "com.github.slick.slick" % "slick_3" % "nafg~dottyquery-SNAPSHOT"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.36" % Test

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

resolvers += "jitpack" at "https://jitpack.io"

coverageExcludedPackages := "*.gui.*"
