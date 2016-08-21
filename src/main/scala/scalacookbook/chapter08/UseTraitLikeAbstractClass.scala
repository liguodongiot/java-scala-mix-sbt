package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object UseTraitLikeAbstractClass {

}


package cb008.section3{

  trait Pet {
    def speak { println("Yo") } // concrete implementation
    def comeToMaster // abstract method
  }
  class Dog extends Pet {
    // don't need to implement 'speak' if you don't need to
    def comeToMaster { ("I'm coming!") }
  }
  class Cat extends Pet {
    // override the speak method
    override def speak { ("meow") }
    def comeToMaster { ("That's not gonna happen.") }
  }

  //If a class extends a trait without implementing its abstract methods,
  // it must be defined as abstract.
  abstract class FlyingPet extends Pet {
    def fly { ("I'm flying!") }
  }

}
