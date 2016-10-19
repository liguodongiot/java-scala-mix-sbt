package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/23.
 */

object CreateComprehension extends App{

  //在for循环中通过yield语句 从一个已存在的集合创建一个新集合
  val names = Array("chris", "ed", "maurice")

  val capNames = for (e <- names) yield e.capitalize

  print("capNames ; ")
  capNames.map(_+" ").foreach(print)
  println

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
