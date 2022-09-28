val scala3Version = "3.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-akka-http-server",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "com.typesafe.akka" % "akka-actor-typed_2.13" % "2.6.14",
      "com.typesafe.akka" % "akka-stream-typed_2.13" % "2.6.14",
      "com.typesafe.akka" % "akka-http_2.13" % "10.2.4",
      "com.typesafe.akka" % "akka-http-spray-json_2.13" % "10.2.4",
      "ch.megard" % "akka-http-cors_2.13" % "1.1.1",
    )
  )
