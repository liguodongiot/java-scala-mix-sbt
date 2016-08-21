package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */
object DefineAuxiliaryConstructor extends App{
  val p1 = new Pizza(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  println(p1)
  val p2 = new Pizza(Pizza.DEFAULT_CRUST_SIZE)
  println(p2)
  val p3 = new Pizza(Pizza.DEFAULT_CRUST_TYPE)
  println(p3)
  val p4 = new Pizza
  println(p4)


  //Discussion
  val pt = new PizzaT

  //Generating auxiliary constructors for case classes
  // initial case class
  case class Person (var name: String, var age: Int)
  val ps = Person("John Smith", 30)
  val ps2 = Person("John Smith", 30) //等价于 val ps2 = Person.apply("John Smith", 30)


  val a = PersonQQ() // corresponds to apply()
  val b = PersonQQ("Pam") // corresponds to apply(name: String)
  val c = PersonQQ("William Shatner", 82)
  println(a)
  println(b)
  println(c)

  // verify the setter methods work
  a.name = "Leonard Nimoy"
  a.age = 83
  println(a)

}


// primary constructor
class Pizza (var crustSize: Int, var crustType: String) {

  // one-arg auxiliary constructor
  def this(crustSize: Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }

  // one-arg auxiliary constructor
  def this(crustType: String) {
    //this(Pizza.DEFAULT_CRUST_SIZE, crustType)

    //等价于//

    this(Pizza.DEFAULT_CRUST_SIZE)
    this.crustType = Pizza.DEFAULT_CRUST_TYPE
  }
  // zero-arg auxiliary constructor
  def this() {
    this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  }
  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}

object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"
}


class PizzaT () {
  var crustSize = 0
  var crustType = ""
  def this(crustSize: Int) {
    this()
    this.crustSize = crustSize
  }
  def this(crustType: String) {
    this()
    this.crustType = crustType
  }


  // more constructors here ...
  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}



// the case class
case class PersonQQ (var name: String, var age: Int)

// the companion object(伴生对象)
object PersonQQ {

  def apply() = new PersonQQ("<no name>", 0)
  def apply(name: String) = new PersonQQ(name, 0)

}