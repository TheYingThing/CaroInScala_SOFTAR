name := "CaroInScala"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)
