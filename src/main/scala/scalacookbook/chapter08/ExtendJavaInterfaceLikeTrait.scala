package scalacookbook.chapter08

/**
  * Created by liguodong on 2016/7/21.
  */
object ExtendJavaInterfaceLikeTrait extends App{

  val dog = new Dog
  dog.speak
  dog.wag
  dog.run

}

// scala
class Dog extends Animal with Wagging with Running {
  def speak { println("Woof") }
  def wag { println("Tail is wagging!") }
  def run { println("I'm running!") }
}