package scalacookbook.chapter06

/**
 * Created by liguodong on 2016/7/9.
 */
object CreateStaticMembersObject extends App{

  println(Pizza.CRUST_TYPE_THIN)
  println(Pizza.getFoo)

  var p = new Pizza(Pizza.CRUST_TYPE_THICK)
  println(p)

  //Discussion
//  Although this approach is different than Java, the recipe is straightforward:
//  • Define your class and object in the same file, giving them the same name.
//  • Define members that should appear to be “static” in the object.
//  • Define nonstatic (instance) members in the class.


  //Accessing private members
  val f = new Foo
  println(Foo.double(f)) // prints 4

  val fObj = new Foo
  fObj.printObj


}


// Pizza class
class Pizza (var crustType: String) {
  override def toString = "Crust type is " + crustType
}

// companion object
object Pizza {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"
}

class Foo {
  private val secret = 2

  // access the private object field 'obj'
  def printObj { println(s"I can see ${Foo.obj}") }

}

object Foo {
  // access the private class field 'secret'
  def double(foo: Foo) = foo.secret * 2

  private val obj = "Foo's object"
}

