package scalacookbook.chapter20

import java.io.{FileNotFoundException, IOException}


import com.typesafe.scalalogging.slf4j.Logger
import org.slf4j.LoggerFactory

import scala.io.Source


/**
  * Created by liguodong on 2016/8/27.
  */
object MatchExpressionPatternMatch extends App{

  //Replacement for the Java switch statement and unwieldy if/then statements
  val i= 2

  val month = i match {
    case 1 => "January"
    case 2 => "February"
    // more months here ...
    case 11 => "November"
    case 12 => "December"
    case _ => "Invalid month" // the default, catch-all
  }

  //It can be used in the same way to replace unwieldy if/then/else statements:
  val numType = i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }

  //In try/catch expressions
  def readTextFile(filename: String): Option[List[String]] = {
    try {
      Some(Source.fromFile(filename).getLines.toList)
    } catch {
      case e: Exception => None
    }
  }

  //To catch multiple exceptions in a try/catch expression,
  // list the exception types in the catch clause, just like a match expression.


  def readTextFile2(filename: String): Option[List[String]] = {
    val logger = Logger(LoggerFactory.getLogger("name"))
    try {
      Some(Source.fromFile(filename).getLines.toList)
    } catch {
      case ioe: IOException =>
        //logger.error("IOException")
        logger.error("<IOException>",ioe)
        None
      case fnf: FileNotFoundException =>
        //logger.error("FileNotFoundException")
        logger.error("<FileNotFoundException>",fnf)
        None
    }
  }

  //As the body of a function or method
  def isTrue(a: Any) = a match {
    case 0 | "" => false
    case _ => true
  }

  //a match expression used as the body of a function
  // will accept a parameter as input,
  // match against that parameter, and then return a value.
  class Person
  case class Dog()
  case class Parrot(name:String)
  def getClassAsString(x: Any):String = x match {
    case s: String => "String"
    case i: Int => "Int"
    case l: List[_] => "List"
    case p: Person => "Person"
    case Dog() => "That was a Dog"
    case Parrot(name) => s"That was a Parrot, name = $name"
    case _ => "Unknown"
  }


  //Use with Option/Some/None
  //Match expressions work well with the Scala Option/Some/None types.
  // For instance, given a method that returns an Option:
  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

  val aString = "123"
  // handle the result from toInt with a match expression
  toInt(aString) match {
    case Some(i) => println(i)
    case None => println("Error: Could not convert String to Int.")
  }

  //In actors
  /*
  class SarahsBrain extends Actor {
    def receive = {
      case StartMessage => handleStartMessage
      case StopMessage => handleStopMessage
      case SetMaxWaitTime(time) => helper ! SetMaxWaitTime(time)
      case SetPhrasesToSpeak(phrases) => helper ! SetPhrasesToSpeak(phrases)
      case _ => log.info("Got something unexpected.")
    }
    // other code here ...
  }
  */

}
