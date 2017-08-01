name := """g2-nucleus"""

organization := "com.liaison"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(guice,
  "com.typesafe.akka" % "akka-actor_2.12" % "2.5.3",
  javaWs
)

libraryDependencies += guice

libraryDependencies += "org.testng" % "testng" % "6.8" 

libraryDependencies += "junit" % "junit" % "4.8.2" 

excludeDependencies += "org.junit" % "junit"

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.1"

javaOptions in Test ++= Seq(
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9998",
  "-Xms512M",
  "-Xmx1536M",
  "-Xss1M",
  "-XX:MaxPermSize=384M"
)
