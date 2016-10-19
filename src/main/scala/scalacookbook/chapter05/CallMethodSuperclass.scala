package scalacookbook.chapter05

import scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object CallMethodSuperclass extends App{

  class Bundle

  class Activity{
    def onCreate(bundle: Bundle): Unit ={
    }
  }

  class WelcomeActivity extends Activity {
    override def onCreate(bundle: Bundle) {
      super.onCreate(bundle)
      // more code here ...
    }
  }

  ///////////////////////////////

  class FourLeggedAnimal {
    def walk { println("I'm walking") }
    def run { println("I'm running") }
  }

  class Dog extends FourLeggedAnimal {
    def walkThenRun {
      super.walk
      super.run
    }
  }
  val suka = new Dog
  suka.walkThenRun

  /////////////////////////////

  import section02._
  val c = new Child

  println(s"c.printSuper = ${c.printSuper}")
  println(s"c.printMother = ${c.printMother}")
  println(s"c.printFather = ${c.printFather}")
  println(s"c.printHuman = ${c.printHuman}")

  println("==================")
  val d = new Dog2
  d.walkThenRun

  println("==================")
  val d2 = new Dog3
  d2.walkThenRun


}


package section02{

  trait Human {
    def hello = "the Human trait"
  }
  trait Mother extends Human {
    override def hello = "Mother"
  }
  trait Father extends Human {
    override def hello = "Father"
  }

  //多个特质
  class Child extends Human with Mother with Father {
    def printSuper = super.hello
    def printMother = super[Mother].hello
    def printFather = super[Father].hello
    def printHuman = super[Human].hello
  }

  //the following code won’t compile because Dog doesn’t directly extend the Animal trait.
  trait Animal {
    def walk { println("Animal is walking") }
  }

  class FourLeggedAnimal extends Animal {

    override def walk { println("I'm walking on all fours") }

  }

  //继承类
  class Dog2 extends FourLeggedAnimal {
    def walkThenRun {
      super.walk // works
      super[FourLeggedAnimal].walk // works
      //super[Animal].walk // error: won't compile
    }
  }

  class Dog3 extends FourLeggedAnimal with Animal{
    def walkThenRun {
      super.walk // works
      super[FourLeggedAnimal].walk // works
      super[Animal].walk // works
    }
  }


}
