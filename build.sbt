val scala3Version = "3.2.0"
val AkkaVersion = "2.6.20"
val AkkaHttpVersion = "10.2.10"
val AkkaHttpCorsVersion = "1.1.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-akka-http-server",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
      "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
      "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
      "ch.megard" %% "akka-http-cors" % AkkaHttpCorsVersion
    )
  )
