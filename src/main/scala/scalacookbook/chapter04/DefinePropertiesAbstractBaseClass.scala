package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */
object DefinePropertiesAbstractBaseClass extends App{

  import section13._

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
  //Concrete val fields in abstract classes
  //当在抽象类中定义了val，可以提供初始值，然后在子类中重写该值。
  val dogInit = new DogInit
  dogInit.sayHello
  println("----------------")

  val dogBoth = new DogBoth
  println("----------------")

  //为了阻止抽象类中的val被子类重写，声明属性为final val
  //final val greeting = "Hello"

  //Concrete var fields in abstract classes
  val dogVar = new DogVar
  println(dogVar)

  //Don’t use null
  val dogNotNull = new DogNotNull
  println(dogNotNull)

}

package section13{

  abstract class Pet (name: String) {
    //Abstract val and var fields
    val greeting: String
    var age: Int

    def sayHello { println(greeting) }

    override def toString = s"I say $greeting, and I'm $age"
  }

  class Dog (name: String) extends Pet (name) {
    //注意：属性要重新制定为var或val
    val greeting = "Woof"
    var age = 2
  }
  class Cat (name: String) extends Pet (name) {
    val greeting = "Meow"
    var age = 5
  }


  abstract class AnimalInit {
    val greeting = "Hello" // provide an initial value
    def sayHello { println(greeting) }
    def run
  }
  class DogInit extends AnimalInit {
    override val greeting = "Woof" // override the value
    def run { println("Dog is running") }
  }

  //greeting变量在两个类中都被创建
  abstract class AnimalBoth {
    val greeting = { println("Animal"); "Hello" }
  }
  class DogBoth extends AnimalBoth {
    override val greeting = { println("Dog"); "Woof" }
  }


  abstract class AnimalVar {
    var greeting = "Hello"
    var age = 0
    override def toString = s"I say $greeting, and I'm $age years old."
  }
  class DogVar extends AnimalVar {
    // 因为属性在抽象父类中已经声明并初始化了，
    // 因此在子类中没有必要再重新声明为var或val.
    greeting = "Woof"
    age = 2
  }


  //you shouldn’t use null values in these situations. If you’re tempted to
  //use a null, instead initialize the fields using the Option/Some/None pattern.
  trait AnimalNotNull {
    val greeting: Option[String]
    var age: Option[Int] = None
    override def toString = s"I say $greeting, and I'm $age years old."
  }
  class DogNotNull extends AnimalNotNull {
    val greeting = Some("Woof")
    age = Some(2)
  }


}