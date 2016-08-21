package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/27.
  */
object ExtractUniqueElementFromSequence extends App{

  val x = Vector(1, 1, 2, 3, 3, 4)
  val y = x.distinct
  y.foreach(x=>print(x+", "))

  println()

  val s = x.toSet
  s.foreach(print)

  println()

  //Using distinct with your own classes
  val dale1 = new Person("Dale", "Cooper")
  val dale2 = new Person("Dale", "Cooper")
  val ed = new Person("Ed", "Hurley")
  val list = List(dale1, dale2, ed)
  val uniques = list.distinct

  uniques.foreach(println)

  val a = collection.mutable.ArrayBuffer(1,2,3)



}


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