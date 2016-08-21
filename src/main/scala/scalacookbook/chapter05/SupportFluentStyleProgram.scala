package scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object SupportFluentStyleProgram extends App{

  import part9._

  val employee = new Employee

  // use the fluent methods
  employee.setFirstName("Al")
    .setLastName("Alexander")
    .setRole("Developer")
  println(employee)


  //Discussion

  //If you’re sure your class won’t be extended,
  //specifying this.type as the return type of your set* methods isn’t necessary;

  val p = new Pizza
  p.setCrustSize(14)
    .setCrustType("thin")
    .addTopping("cheese")
    .addTopping("green olives")
  p.print()

  println("~~~~~~~~~~~~~")
  p.setCrustSize(142)
    .setCrustType("thin2")
    .addTopping("cheese2")
    .addTopping("green olives2")
    .print()


}

package part9{
  class Person {
    protected var fname = ""
    protected var lname = ""
    def setFirstName(firstName: String): this.type = {
      fname = firstName
      this
    }
    def setLastName(lastName: String): this.type = {
      lname = lastName
      this
    }
  }

  class Employee extends Person {
    protected var role = ""
    def setRole(role: String): this.type = {
      this.role = role
      this
    }
    override def toString = {
      "%s, %s, %s".format(fname, lname, role)
    }
  }

  final class Pizza {

    import scala.collection.mutable.ArrayBuffer
    private val toppings = ArrayBuffer[String]()
    private var crustSize = 0
    private var crustType = ""

    def addTopping(topping: String) = {
      toppings += topping
      this
    }
    def setCrustSize(crustSize: Int) = {
      this.crustSize = crustSize
      this
    }

    def setCrustType(crustType: String) = {
      this.crustType = crustType
      this
    }

    def print() {
      println(s"crust size: $crustSize")
      println(s"crust type: $crustType")
      println(s"toppings: $toppings")
    }
  }
}