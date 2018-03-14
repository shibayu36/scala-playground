import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.11",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
      "org.json4s" %% "json4s-native" % "3.5.3",
      "org.json4s" %% "json4s-jackson" % "3.5.3",
      "org.postgresql" % "postgresql" % "42.1.4",
      "com.zaxxer" % "HikariCP" % "2.7.1",
      "me.geso" % "nanobench" % "0.2.1",
      "joda-time" % "joda-time" % "2.9.9",
      scalaTest % Test
    )
  )
