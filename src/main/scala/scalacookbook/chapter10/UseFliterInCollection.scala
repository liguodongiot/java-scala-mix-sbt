package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object UseFliterInCollection extends App{

  import scala._

  val x = List.range(1, 10)

  // create a list of all the even numbers in the list
  val evens = x.filter(_ % 2 == 0)
  println(evens)

  //Discussion
  val fruits = Set("orange", "peach", "apple", "banana")
  val x2 = fruits.filter(_.startsWith("a"))
  val y2 = fruits.filter(_.length > 5)

  println(x2)
  println(y2)

  println("-----------")

  val list = "apple" :: "banana" :: 1 :: 2 :: Nil

  val strings = list.filter {
    case s: String => true
    case _ => false
  }

  println(strings)


  def onlyStrings(a: Any) = a match {
    case s: String => true
    case _ => false
  }
  val strings2 = list.filter(onlyStrings)

  println(strings2)

  def getFileContentsWithoutBlanksComments(canonicalFilename: String):
  List[String] = {

    io.Source.fromFile(canonicalFilename)
      .getLines
      .toList
      .filter(_.trim != "")
      .filter(_.charAt(0) != '#')
  }



}
