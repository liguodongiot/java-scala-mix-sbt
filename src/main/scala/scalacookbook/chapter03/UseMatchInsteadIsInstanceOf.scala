package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */
object UseMatchInsteadIsInstanceOf {

  // use the isInstanceOf method to test the type of an object
  // if (x.isInstanceOf[Foo]) { do something ...

  def isPerson(x: Any): Boolean = x match {
    case p: Person => true
    case _ => false
  }

  trait SentientBeing
  trait Animal extends SentientBeing
  case class Dog(name: String) extends Animal

  case class Person(name: String, age: Int) extends SentientBeing

  // later in the code ...
  def printInfo(x: SentientBeing) = x match {
    case Person(name, age) => // handle the Person
    case Dog(name) => // handle the Dog
  }

  //with more complex needs, a match expression is more readable
  // than an if/else statement.


}
