package scalacookbook.chapter15

import net.liftweb.json.JsonAST
import net.liftweb.json.JsonDSL._
import net.liftweb.json.Printer.{compact, pretty}

/**
  * Created by liguodong on 2016/8/17.
  */
object LiftJsonWithCollections extends App{

  //how to generate JSON strings from a simple Scala Map
  val json = List(1, 2, 3)
  println(compact(JsonAST.render(json)))

  val map = Map("fname" -> "Alvin", "lname" -> "Alexander")
  // use the compact method as shown
  println(compact(JsonAST.render(map)))
  println(pretty(JsonAST.render(map)))



}
