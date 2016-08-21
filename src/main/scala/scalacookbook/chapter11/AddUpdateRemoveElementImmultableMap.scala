package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object AddUpdateRemoveElementImmultableMap extends App{

  val a = Map("AL" -> "Alabama")

  // add one element
  val b = a + ("AK" -> "Alaska")
  println(b)

  // add multiple elements
  val c = b + ("AR" -> "Arkansas", "AZ" -> "Arizona")
  println(c)

  //update a key/value pair with an immutable map
  val d = c + ("AR" -> "banana")
  println(d)

  //To remove one element, use the - method.
  val e = d - "AR"
  println(e)

  //To remove multiple elements, use the - or -- methods:
  val f = e - "AZ" - "AL"
  println(f)

  //Discussion
  var x = Map("AL" -> "Alabama")//x: scala.collection.mutable.Map[String,String] = Map(AL -> Alabama)

  // add one element
  x += ("AK" -> "Alaska"); println(x)   //Map(AL -> Alabama, AK -> Alaska)

  // add multiple elements
  x += ("AR" -> "Arkansas", "AZ" -> "Arizona"); println(x) //Map(AZ -> Arizona, AL -> Alabama, AR -> Arkansas, AK -> Alaska)

  // add a tuple to a map (replacing the previous "AR" key)
  x += ("AR" -> "banana"); println(x)

  // remove an element
  x -= "AR"; println(x)   //Map(AZ -> Arizona, AL -> Alabama, AK -> Alaska)

  // remove multiple elements (uses varargs method)
  x -= ("AL", "AZ"); println(x)   //Map(AK -> Alaska)

  //重新分配map
  // reassign the map that 'x' points to
  x = Map("CO" -> "Colorado")
  println(x)

  //即使我们声明的不可变Map是var.我们仍然不能对里面的内容进行修改。

}
