package scalacookbook.chapter04

/**
  * 一个Scala类的主构造函数是一个组合:
  * 构造函数的参数
  * 类中的方法被调用
  * 类中的语句和表达式被执行
  *
  * Created by liguodong on 2016/6/30.
  */

object CreatePrimaryConstructor extends App{

  import section01._

  val p = new Person("Adam", "Meyer")
  p.firstName = "Scott"
  p.lastName = "Jones"
  println(p.firstName)
  println(p.lastName)

  p.age = 30
  println(p.age)

  println("==============")

  val m = new Man
  // the 'normal' mutator approach
  m.name = "Ron Artest"
  println(m)

  // the 'hidden' mutator method（隐藏的赋值方法）
  m.name_$eq("Metta World Peace")
  println(m)

}

package section01{

  class Person(var firstName: String, var lastName: String) {
    println("the constructor begins")

    // some class fields
    private val HOME = System.getProperty("user.home")
    var age = 0

    // some methods
    override def toString = s"$firstName $lastName is $age years old"
    def printHome { println(s"HOME = $HOME") }
    def printFullName { println(this) } // uses toString

    printHome
    printFullName
    println("still in the constructor")


  }

  class Man {
    var name = ""
    override def toString = s"name = $name"
  }
}

