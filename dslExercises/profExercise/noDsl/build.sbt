ThisBuild / scalaVersion := "2.13.4"

lazy val brainfuck = (project in file("."))
  .settings(
    name := "exercise",
    scalacOptions += "-deprecation",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  )
