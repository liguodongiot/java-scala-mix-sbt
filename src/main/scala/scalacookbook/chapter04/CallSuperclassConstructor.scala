package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */
object CallSuperclassConstructor extends App{

  //the Dog class is defined to call the primary constructor of the Animal class,
  //which is a one-arg constructor that takes name as its parameter
  class AnimalOne (var name: String) {
    // ...
  }
  class DogOne (name: String) extends AnimalOne (name) {
    // ...
  }

  // (1) primary constructor
  class Animal (var name: String, var age: Int) {
    // (2) auxiliary constructor
    def this (name: String) {
      this(name, 0)
    }

    override def toString = s"$name is $age years old"
  }

  // calls the Animal one-arg constructor
  class Dog (name: String) extends Animal (name) {
    println("Dog constructor called")
  }

  // call the two-arg constructor
  /*class Dog (name: String) extends Animal (name, 0) {
    println("Dog constructor called")
  }*/

}

object AuxiliaryConstructors{
  case class Address (city: String, state: String)
  case class Role (role: String)

  class Person (var name: String, var address: Address) {
    // no way for Employee auxiliary constructors to call this constructor
    def this (name: String) {
      this(name, null)
      address = null
    }
    override def toString = if (address == null) name else s"$name @ $address"
  }

  class Employee (name: String, role: Role, address: Address)
    extends Person (name, address) {

    def this (name: String) {
      this(name, null, null)
    }

    def this (name: String, role: Role) {
      this(name, role, null)
    }

    def this (name: String, address: Address) {
      this(name, null, address)
    }
  }
}