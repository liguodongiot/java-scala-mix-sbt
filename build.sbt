import sbt.Keys._

name := "java-scala-mix-sbt"

version := "1.0"

scalaVersion := "2.11.7"

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
  , "com.typesafe.scala-logging" % "scala-logging-slf4j_2.11" % "2.1.2"
  , "com.typesafe.akka" %% "akka-actor" % "2.3.15"
  , "org.mockito" % "mockito-core" % "1.10.19" % "test"
  , "net.liftweb" % "lift-webkit_2.11" % "2.6.3"
  , "net.liftweb" % "lift-json_2.11" % "2.6.3"
  , "com.google.code.gson" % "gson" % "2.6.2"
)



libraryDependencies := {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor == 10 =>
      libraryDependencies.value ++ Seq(
        "org.scalatest" % "scalatest_2.10" % "2.2.6" % "test",
        "com.github.nscala-time" % "nscala-time_2.10" % "2.8.0"
      )
    case Some((2, scalaMajor)) if scalaMajor == 11 =>
      libraryDependencies.value ++ Seq(
        "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test",
        "com.github.nscala-time" % "nscala-time_2.11" % "2.8.0"
      )
  }
}

//libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"
//libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.6" % "test"
//libraryDependencies += "com.github.nscala-time" % "nscala-time_2.10" % "2.8.0"
//libraryDependencies += "com.github.nscala-time" % "nscala-time_2.11" % "2.8.0"


//https://github.com/scala/scala-xml
// add scala-xml dependency when needed (for Scala 2.11 and newer) in a robust way
// this mechanism supports cross-version publishing
// taken from: http://github.com/scala/scala-module-dependency-sample
libraryDependencies := {
  CrossVersion.partialVersion(scalaVersion.value) match {
    // if scala 2.11+ is used, add dependency on scala-xml module
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      libraryDependencies.value ++ Seq(
        "org.scala-lang.modules" %% "scala-xml" % "1.0.3",
        "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
        "org.scala-lang.modules" %% "scala-swing" % "1.0.1")
    case _ =>
      // or just libraryDependencies.value if you don't depend on scala-swing
      libraryDependencies.value :+ "org.scala-lang" % "scala-swing" % scalaVersion.value
  }
}


libraryDependencies := {
  val spark_version = "2.0.0"
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor == 10 =>
      libraryDependencies.value ++ Seq(
        "org.apache.spark" % "spark-core_2.10" % spark_version,
        "org.apache.spark" % "spark-sql_2.10" % spark_version,
        "org.apache.spark" % "spark-hive_2.10" % spark_version
      )
    case Some((2, scalaMajor)) if scalaMajor == 11 =>
      libraryDependencies.value ++ Seq(
        "org.apache.spark" % "spark-core_2.11" % spark_version,
        "org.apache.spark" % "spark-sql_2.11" % spark_version,
        "org.apache.spark" % "spark-hive_2.11" % spark_version
      )
  }
}




