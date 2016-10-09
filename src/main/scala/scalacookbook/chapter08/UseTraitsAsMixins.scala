package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object UseTraitsAsMixins extends App{

  import section04._

  val zeus = new Dog("Zeus")
  zeus.ownerIsHome
  zeus.jumpForJoy
  zeus.speak

}

package section04{

  trait Tail {
    def wagTail { println("tail is wagging") }
    def stopTail { println("tail is stopped") }
  }

  abstract class Pet (var name: String) {
    def speak // abstract
    def ownerIsHome { println("excited") }
    def jumpForJoy { println("jumping for joy") }
  }

  class Dog (name: String) extends Pet (name) with Tail {
    def speak { println("woof") }

    override def ownerIsHome {
      wagTail
      speak
    }
  }
}
