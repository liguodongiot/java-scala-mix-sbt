name := "java-scala-mix-sbt"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.15",
  "commons-dbcp" % "commons-dbcp" % "1.4",
  "org.springframework" % "spring-beans" % "4.2.7.RELEASE",
  "org.springframework" % "spring-core" % "4.2.7.RELEASE",
  "org.springframework" % "spring-context" % "4.2.7.RELEASE",
  "org.springframework" % "spring-aop" % "4.2.7.RELEASE",
  "org.springframework" % "spring-expression" % "4.2.7.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.2.7.RELEASE"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.39"
