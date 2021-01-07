name := "scala-snippets"

version := "0.1"

scalaVersion := "2.13.4"

idePackagePrefix := Some("com.company")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.10.0" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")