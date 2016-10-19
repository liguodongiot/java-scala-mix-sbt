package scalacookbook.chapter20

import scala.util.{Failure, Success, Try}
import scala._

/**
  * Created by liguodong on 2016/8/27.
  */
object NotReturnMethods extends App{

  //  def doSomething: Option[String] = { ... }
  //  def toInt(s: String): Option[Int] = { ... }
  //  def lookupPerson(name: String): Option[Person] = { ... }
  def readTextFile(filename: String): Option[List[String]] = {
    try {
      Some(io.Source.fromFile(filename).getLines.toList)
    } catch {
      case e: Exception => None
    }
  }
  //This method returns a List[String] wrapped in a Some
  // if the file can be found and read, or None if an exception occurs.

  //if you want the error information instead of a Some or None,
  // use the Try/Success/Failure approach instead

  def readTextFile2(filename: String): Try[List[String]] = {
    Try(io.Source.fromFile(filename).getLines.toList)
  }
  val filename = "/etc/passwd"
  readTextFile2(filename) match {
    case Success(lines) => lines.foreach(println)
    case Failure(f) => println(f)
  }

}
