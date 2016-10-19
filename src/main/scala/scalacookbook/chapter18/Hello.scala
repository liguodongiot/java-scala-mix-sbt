package scalacookbook.chapter18

/**
  * Created by liguodong on 2016/8/22.
  */

object Hello extends App {
  val p = Person("Alvin Alexander")
  println("Hello from " + p.name)
}
case class Person(var name: String)