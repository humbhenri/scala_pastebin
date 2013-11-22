seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

name := "scala_pastebin"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.2.0"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.0"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"

resolvers += Resolver.sonatypeRepo("public")

mainClass in oneJar := Some("scala_pastebin.Main")