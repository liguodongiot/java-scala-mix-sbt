package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object UseTraitLikeAbstractClass extends App{

  import section03._
  val d = new Dog
  d.comeToMaster
  d.speak

  println("--------------")

  val c = new Cat
  c.comeToMaster
  c.speak
  println("--------------")

  val p = new FlyPet
  p.fly
  p.comeToMaster
  p.speak



}


package section03{

  trait Pet {
    def speak { println("Yo") } // concrete implementation
    def comeToMaster // abstract method
  }

  class Dog extends Pet {
    // don't need to implement 'speak' if you don't need to
    def comeToMaster { println("I'm coming!") }
  }

  class Cat extends Pet {
    // override the speak method
    override def speak { println("meow") }
    def comeToMaster { println("That's not gonna happen.") }
  }

  //If a class extends a trait without implementing its abstract methods,
  // it must be defined as abstract.
  abstract class FlyingPet extends Pet {
    def fly { println("I'm flying!") }
  }

  class FlyPet extends FlyingPet{
    // concrete implementation
    override def comeToMaster: Unit = println("I'm fine....")
  }


}
