package scalacookbook.chapter04

/**
 * 你想为类定义一个equals方法，因此你能够比较对象实例。
 *
 * Created by liguodong on 2016/7/3.
 */
object DefineEqualMethod extends App{

  import section15._

  // these first two instances should be equal
  val nimoy = new Person("Leonard Nimoy", 82)
  val nimoy2 = new Person("Leonard Nimoy", 82)
  val shatner = new Person("William Shatner", 82)
  val ed = new Person("Ed Chigliak", 20)


  //With the equals method defined, you can compare instances of a Person with ==
  println(nimoy == nimoy)
  println(nimoy == nimoy2)
  println(nimoy2 == nimoy)
  println(nimoy != shatner)
  println(shatner != nimoy)
  println(nimoy != null)
  println(nimoy != "Leonard Nimoy")
  println(nimoy != ed)

  //在scala中，== 比较两个 对象相等。
  //在java中，== 比较两个 引用相等。
  //Scala中， ==是一个方法，你可以使用它比较每一个类的两个实例。他会在底层调用equals方法。

  // these first two instance should be equal
  val eNimoy1 = new Employee("Leonard Nimoy", 82, "Actor")
  val eNimoy2 = new Employee("Leonard Nimoy", 82, "Actor")
  val pNimoy = new Person("Leonard Nimoy", 82)
  val eShatner = new Employee("William Shatner", 82, "Actor")

  println(eNimoy1 == eNimoy1)
  println(eNimoy1 == eNimoy2)
  println(eNimoy2 == eNimoy1)
  println(eNimoy1 != pNimoy)
  println(pNimoy != eNimoy1)

}

package section15{

  class Person (name: String, age: Int) {
    def canEqual(a: Any) = a.isInstanceOf[Person]
    override def equals(that: Any): Boolean =
      that match {
        case that: Person => that.canEqual(this) && this.hashCode == that.hashCode
        case _ => false
      }
    override def hashCode:Int = {
      val prime = 31
      var result = 1
      result = prime * result + age;
      result = prime * result + (if (name == null) 0 else name.hashCode)
      return result
    }
  }

  class Employee(name: String, age: Int, var role: String)
    extends Person(name, age)
  {
    override def canEqual(a: Any) = a.isInstanceOf[Employee]
    override def equals(that: Any): Boolean =
      that match {
        case that: Employee =>
          that.canEqual(this) && this.hashCode == that.hashCode
        case _ => false
      }
    override def hashCode:Int = {
      val ourHash = if (role == null) 0 else role.hashCode
      super.hashCode + ourHash
    }
  }

}

