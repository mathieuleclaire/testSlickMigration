import sbt._
import Keys._

val defaultSettings = Seq(
  name := "testMigration",
  version := "0.1",
  scalaVersion := "2.11.8",
  resolvers := Seq(Resolver.sonatypeRepo("snapshots"),
    DefaultMavenRepository, Resolver.jcenterRepo
  )
)

val demo = project.in(file("demo")) settings (defaultSettings) settings(
  libraryDependencies += "com.h2database" % "h2" % "1.4.190",
  libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0-M2",
  libraryDependencies += "io.github.nafg" %% "slick-migration-api" % "0.4.0-M1",
  libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
)
