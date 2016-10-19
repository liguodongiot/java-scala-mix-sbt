package scalacookbook.chapter12

/**
  * There are two primary ways to open and read a text file:
  * 1、Use a concise, one-line syntax. This has the side effect of leaving the file open,
  * but can be useful in short-lived programs, like shell scripts.
  *
  * 2、Use a slightly longer approach that properly closes the file.
  *
  * Created by liguodong on 2016/8/2.
  */
object HowOpenReadTextFile extends App {

  //方式一、Using the concise syntax
  import scala.io.Source
  val filename = "D:\\lilili.txt"
  for (line <- Source.fromFile(filename).getLines) {
    println(line)
  }


  val lines = Source.fromFile("D:\\lilili.txt").getLines.toList
  println(lines)

  val lines2 = Source.fromFile("D:\\lilili.txt").getLines.toArray
  lines.foreach(x=>print(x+" "))
  println


  val fileContents = Source.fromFile(filename).getLines.mkString
  println(fileContents)

  //方式二、Properly closing the file
  val bufferedSource = Source.fromFile("D:\\lilili.txt")
  for (line <- bufferedSource.getLines) {
    println(line.toUpperCase)
  }
  bufferedSource.close

  //Discussion
  import scala._
  //Leaving files open
  // leaves the file open
  for (line <- io.Source.fromFile("D:\\lilili.txt").getLines) {
    println(line)
  }

  // also leaves the file open
  val contents = io.Source.fromFile("D:\\lilili.txt").mkString
  println("contents:"+contents)



  //自动关闭资源
  //Automatically closing the resource

  //Loan Pattern
  /*
  def using[A](r : Resource)(f : Resource => A) : A =
  try {
    f(r)
  } finally {
    r.dispose()
  }
  */
  object Control {
    def using[A <: { def close(): Unit }, B]
    (resource: A)(f: A => B): B =
      try {
        f(resource)
      } finally {
        resource.close()
      }
  }

  import Control._

  //io.Source.fromFile("D:\\lilili.txt") 相当于A
  /*
  {
    source => {
      for (line <- source.getLines) {
        println("liguodong:"+line)
      }
    }
  }
  相当于f
  */
  using(io.Source.fromFile("D:\\lilili.txt")) { source => {
      for (line <- source.getLines) {
        println("liguodong:"+line)
      }
    }
  }


  //处理异常

  import scala.io.Source
  import java.io.{FileNotFoundException, IOException}
  val fileName = "D:\\people.txt"
  try {
    for (line <- Source.fromFile(fileName).getLines) {
      println(line)
    }
  } catch {
    case e: FileNotFoundException => println("Couldn't find that file.")
    case e: IOException => println("Got an IOException!")
  }


  //This method returns a Some(List[String]) on success,
  //and None if something goes wrong, such as a FileNotFoundException.
  import Control._
  def readTextFile(filename: String): Option[List[String]] = {
    try {
      val lines = using(io.Source.fromFile(filename)) { source =>
        (for (line <- source.getLines) yield line).toList
      }
      Some(lines)
    } catch {
      case e: Exception => None
    }
  }

  //It can be used in the following ways.
  val FILE_NAME = "D:\\people.txt"
  println("--- FOREACH ---")
  val result = readTextFile(FILE_NAME)

  result foreach { strings =>
    strings.foreach(println)
  }

  println("\n--- MATCH ---")
  readTextFile(FILE_NAME) match {
    case Some(lines) => lines.foreach(println)
    case None => println("couldn't read file")
  }


  //Multiple fromFile methods

  //In Scala 2.10, there are eight variations of the fromFile method
  // that let you specify a character encoding, buffer size, codec, and URI.


  // specify the encoding
  Source.fromFile("D:\\people.txt", "UTF-8")


}


