def crossPlugin(x: sbt.librarymanagement.ModuleID) = compilerPlugin(x.cross(CrossVersion.full))

lazy val examples = projectMatrix
  .settings(
    libraryDependencies ++= List(
      "org.http4s" %%% "http4s-ember-server" % "0.23-117-c7f22ef-SNAPSHOT",
      crossPlugin("org.typelevel" % "kind-projector" % "0.13.2"),
    ),
    scalaJSUseMainModuleInitializer := true,
  )
  .jsPlatform(scalaVersions = Seq("2.13.7"))

lazy val root = project
  .in(file("."))
  .aggregate(
    List(examples).flatMap(_.projectRefs): _*
  )
