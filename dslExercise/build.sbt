lazy val prova = (project in file("."))
  .settings(
    name := "prova",
    scalacOptions += "-deprecation",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  )