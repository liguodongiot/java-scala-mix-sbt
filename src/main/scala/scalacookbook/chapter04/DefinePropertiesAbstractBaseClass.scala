package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */
object DefinePropertiesAbstractBaseClass extends App{

  abstract class Pet (name: String) {
    val greeting: String
    var age: Int
    def sayHello { println(greeting) }
    override def toString = s"I say $greeting, and I'm $age"
  }

  class Dog (name: String) extends Pet (name) {
    val greeting = "Woof"
    var age = 2
  }
  class Cat (name: String) extends Pet (name) {
    val greeting = "Meow"
    var age = 5
  }


  val dog = new Dog("Fido")
  val cat = new Cat("Morris")
  dog.sayHello
  cat.sayHello
  println(dog)
  println(cat)
  // verify that the age can be changed
  cat.age = 10
  println(cat)



  //Discussion




}
