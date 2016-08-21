package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */
object HandleConstructParam extends App{

  class Person (var name: String, var address: Address) {
    override def toString = if (address == null) name else s"$name @ $address"
  }

  class Employee (name: String, address: Address, var age: Int)
    extends Person (name, address) {
    // rest of the class
  }

  case class Address (city: String, state: String)


  val teresa = new Employee("Teresa", Address("Louisville", "KY"), 25)

  println(teresa.name)
  println(teresa.address)
  println(teresa.age)

  //Discussion




}
