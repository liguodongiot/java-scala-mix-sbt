package scalacookbook.chapter06

/**
 * Created by liguodong on 2016/7/10.
 */
object CreateObjectWithoutKeyword extends App{

  import section08._

  //Creating a companion object with an apply method
  val dawn = Person("Dawn")

  val a = Array(Person("Dan"), Person("Elijah"))
  a.foreach(println)

  //Declare your class as a case class
  val p = Man("Fred Flinstone")
  println("p : "+p)

  //With case classes, this works because the case class generates
  //an apply method in a companion object for you.

  //Discussion

  //val p = Person("Fred Flinstone") <=~=> val p = Person.apply("Fred Flinstone")

  //Providing multiple constructors with additional apply methods
  val fred = Anamil("Fred")
  val john = Anamil("John", 42)

  //Providing multiple constructors for case classes
  val sa = Student()
  val sb = Student("Al")
  val sc = Student("William Shatner", 82)
  println(sa)
  println(sb)
  println(sc)

  // test the mutator methods
  sa.name = "Leonard Nimoy"
  sa.age = 82
  println(sa)


}

package section08{
  ////////////////////

  class Person {
    var name: String = _
  }

  object Person {

    def apply(name: String): Person = {
      var p = new Person
      p.name = name
      p
    }

  }

  ////////////////////

  case class Man (var name: String)

  ////////////////////

  class Anamil {
    var name = ""
    var age = 0
  }

  object Anamil {
    // a one-arg constructor
    def apply(name: String): Anamil = {
      var p = new Anamil
      p.name = name
      p
    }

    // a two-arg constructor
    def apply(name: String, age: Int): Anamil = {
      var p = new Anamil
      p.name = name
      p.age = age
      p
    }
  }

  ///////////////////

  // want accessor and mutator methods for the name and age fields
  case class Student (var name: String, var age: Int)//name and age are declared as var fields, accessor and mutator methods will both be generated.

  // define two auxiliary constructors
  object Student {
    def apply() = new Student("<no name>", 0)
    def apply(name: String) = new Student(name, 0)
  }
}

