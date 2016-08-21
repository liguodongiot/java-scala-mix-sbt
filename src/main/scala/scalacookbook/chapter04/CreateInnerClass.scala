package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */
object CreateInnerClass extends App{
  val p = new PandorasBox
  p.things.foreach(println)

  p.addThing("Evil Thing #3")
  p.addThing("Evil Thing #4")

  println("~~~~~~~~~~~~~")
  p.things.foreach(println)


  println("=============")
  // inner classes are bound to the object
  val oc1 = new Outer
  val oc2 = new Outer
  val ic1 = new oc1.Inner
  val ic2 = new oc2.Inner
  ic1.x = 10
  ic2.x = 20



  println(s"ic1.x = ${ic1.x}")
  println(s"ic2.x = ${ic2.x}")



  println("----------")
  //include a class inside an object or an object inside a class

  // class inside object(注意括号的位置)
  println(new OuterObject.InnerClass().x)
  // object inside class
  println(new OuterClass().InnerObject.y)

}



class PandorasBox {

  case class Thing (name: String)

  var things = new collection.mutable.ArrayBuffer[Thing]()
  things += Thing("Evil Thing #1")
  things += Thing("Evil Thing #2")
  def addThing(name: String) { things += new Thing(name) }
}


class Outer {
  class Inner {
    var x = 1
  }
}

object OuterObject {
  class InnerClass {
    var x = 1
  }
}
class OuterClass {
  object InnerObject {
    val y = 2
  }
}