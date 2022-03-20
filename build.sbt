name := "CaroInScala"

version := "0.1"

scalaVersion := "3.0.0"
//crossScalaVersions ++= Seq("2.13.8", "3.0.0")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12-RC1" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"

libraryDependencies += "com.google.inject" % "guice" % "4.2.3"

libraryDependencies += ("net.codingwell" %% "scala-guice" % "5.0.2").cross(CrossVersion.for3Use2_13)

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC5"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

coverageExcludedPackages := "*.gui.*"
