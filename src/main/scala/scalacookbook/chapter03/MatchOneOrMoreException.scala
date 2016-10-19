package scalacookbook.chapter03

import java.io.{IOException, FileNotFoundException}

/**
 * Created by liguodong on 2016/6/28.
 */
object MatchOneOrMoreException extends App{

  val s = "Foo"
  //一个
  try {
    val i = s.toInt
  } catch {
    case e: Exception => e.printStackTrace
  }

  def openAndReadAFile(filename:String): Unit ={
    println("this is a test method...")
  }

  //多个
  try {
    openAndReadAFile("test")
  } catch {
    case e: FileNotFoundException => println("Couldn't find that file.")
    case e: IOException => println("Had an IOException trying to read that file")
  }

  //Discussion

  //不关心具体的，捕获所有的异常。
  try {
    openAndReadAFile("foo")
  } catch {
    case t: Throwable => t.printStackTrace()
  }

  //捕获所有异常，然后忽略他们。
  //You can also catch them all and ignore them like this:
  try {
    val i = s.toInt
  } catch {
    case _: Throwable => println("exception ignored")
  }


  //As with Java, you can throw an exception from a catch clause, but because Scala doesn’t
  //have checked exceptions, you don’t need to specify that a method throws the exception.
  //This is demonstrated in the following example, where the method isn’t annotated in any way
  // nothing required here
  def toInt(s: String): Option[Int] =
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => throw e
    }


  //If you prefer to declare the exceptions that your method throws,
  // or you need to interact with Java,
  // add the @throws annotation to your method definition
  @throws(classOf[NumberFormatException])
  def toInt2(s: String): Option[Int] =
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => throw e
    }
}
