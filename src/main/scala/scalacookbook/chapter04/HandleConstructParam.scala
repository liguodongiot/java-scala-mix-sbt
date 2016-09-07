package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */
object HandleConstructParam extends App{

  //Declare your base class as usual with val or var constructor parameters. When defining
  //a subclass constructor, leave the val or var declaration off of the fields that are common
  //to both classes. Then define new constructor parameters in the subclass as val or var
  //fields, as usual.

  case class Address (city: String, state: String)

  //define a Person base class
  class Person (var name: String, var address: Address) {
    override def toString = if (address == null) name else s"$name @ $address"
  }

  //define Employee as a subclass of Person
  //name 和 address属性在父类是公共的，因此，可以省略var的声明。
  //age 是新的。因此需要声明成var
  class Employee (name: String, address: Address, var age: Int)
    extends Person (name, address) {
    // rest of the class
  }


  val teresa = new Employee("Teresa", Address("Louisville", "KY"), 25)

  println(teresa.name)
  println(teresa.address)
  println(teresa.age)

  //Discussion
  // Option 1: define name and address as 'var'
  //class Employee (var name: String, var address: Address)
  //  extends Person (name, address) { ... }

  // Option 2: define name and address without var or val
  //class Employee (name: String, address: Address)
  //  extends Person (name, address) { ... }



}
