import sbt.Keys._

name := "java-scala-mix-sbt"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers ++= Seq(
  "maven Repository" at "http://repo1.maven.org/maven2/"
)

libraryDependencies ++= {
  val akka_version = "2.3.15"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akka_version
    //,"com.typesafe.akka" % "akka-slf4j_2.10" % akka_version
  )
}

libraryDependencies ++={
  val spring_version = "4.2.7.RELEASE"
  Seq(
    "org.springframework" % "spring-beans" % spring_version,
    "org.springframework" % "spring-core" % spring_version,
    "org.springframework" % "spring-context" % spring_version,
    "org.springframework" % "spring-aop" % spring_version,
    "org.springframework" % "spring-expression" % spring_version,
    "org.springframework" % "spring-jdbc" % spring_version
  )
}


libraryDependencies += "commons-dbcp" % "commons-dbcp" % "1.4"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.39"

//libraryDependencies += "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0"
//libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.0.4"
//libraryDependencies += "com.typesafe.scala-logging" % "scala-logging-api_2.10" % "2.1.2"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.3"
  //,"com.typesafe.scala-logging" % "scala-logging-slf4j_2.10" % "2.1.2"
  ,"com.typesafe.scala-logging" % "scala-logging-slf4j_2.11" % "2.1.2"
)

