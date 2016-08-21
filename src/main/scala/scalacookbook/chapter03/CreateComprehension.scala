package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/23.
 */
object CreateComprehension extends App{

  val names = Array("chris", "ed", "maurice")

  val capNames = for (e <- names) yield e.capitalize

  val lengths = for (e <- names) yield {
    // imagine that this required multiple lines of code
    e.length
  }

  var fruits = scala.collection.mutable.ArrayBuffer[String]()
  fruits += "apple"
  fruits += "banana"
  fruits += "orange"

  val out = for (e <- fruits) yield e.toUpperCase

  val fruits2 = "apple" :: "banana" :: "orange" :: Nil

  val out2 = for (e <- fruits2) yield e.toUpperCase


  //discussion
  val outdis = for (e <- fruits) yield e.toUpperCase

  val outdis2 = fruits.map(_.toUpperCase)
}
