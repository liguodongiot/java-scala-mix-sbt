package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object CreateArrayWhoseSizeChange extends App{

  import scala.collection.mutable.ArrayBuffer
  var characters = ArrayBuffer[String]()
  characters += "Ben"
  characters += "Jerry"
  characters += "Dale"

  println(characters)

  // initialize with elements
  val characters2 = collection.mutable.ArrayBuffer("Ben", "Jerry")

  // add one element
  characters2 += "Dale"

  // add two or more elements (method has a varargs parameter)
  characters2 += ("Gordon", "Harry")

  // add multiple elements with any TraversableOnce type
  characters2 ++= Seq("Andy", "Big Ed")

  // append one or more elements (uses a varargs parameter)
  characters2.append("Laura", "Lucy")

  println(characters2)

}
