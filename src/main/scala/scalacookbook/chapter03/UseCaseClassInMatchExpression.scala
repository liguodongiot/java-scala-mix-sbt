package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */

object UseCaseClassInMatchExpression extends App{

  import section12._

  def determineType(x: Animal): String = x match {
    case Dog(moniker) => "Got a Dog, name = " + moniker
    case _:Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a Woodpecker"
    case _ => "That was something else"
  }


  println(determineType(new Dog("Rocky")))
  println(determineType(new Cat("Rusty the Cat")))
  println(determineType(Woodpecker))


}

package section12{
  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal
  case object Woodpecker extends Animal

}