name := "java-scala-mix-sbt"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers ++= Seq(
  "maven Repository" at "http://repo1.maven.org/maven2/"
)

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



