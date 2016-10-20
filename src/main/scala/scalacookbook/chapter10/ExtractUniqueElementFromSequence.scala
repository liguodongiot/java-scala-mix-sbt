package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/27.
  */
object ExtractUniqueElementFromSequence extends App{

  val x = Vector(1, 1, 2, 3, 3, 4)
  // returns a new collection with the duplicate values removed
  val y = x.distinct
  y.foreach(x=>print(x+", "))

  println

  //converting an Array, List, Vector,
  // or other sequence to a Set removes the duplicates.
  val s = x.toSet
  s.foreach(print)

  println

  import scalacookbook.chapter10.section21._

  //Using distinct with your own classes
  //To use distinct with your own class,
  // you’ll need to implement the equals and hashCode methods.


  val dale1 = new Person("Dale", "Cooper")
  val dale2 = new Person("Dale", "Cooper")

  val ed = new Person("Ed", "Hurley")
  val list = List(dale1, dale2, ed)

  //If you remove either the equals method or hashCode method,
  // you’ll see that distinct won’t work as desired.
  val uniques = list.distinct

  uniques.foreach(println)


}

package section21{

  class Person(firstName: String, lastName: String) {

    override def toString = s"$firstName $lastName"

    def canEqual(a: Any) = a.isInstanceOf[Person]

    override def equals(that: Any): Boolean =
      that match {
        case that: Person => that.canEqual(this) && this.hashCode == that.hashCode
        case _ => false
      }

    override def hashCode: Int = {
      val prime = 31
      var result = 1
      result = prime * result + lastName.hashCode;
      result = prime * result + (if (firstName == null) 0 else firstName.hashCode)
      return result
    }

  }

  object Person {
    def apply(firstName: String, lastName: String) =
      new Person(firstName, lastName)
  }
}

