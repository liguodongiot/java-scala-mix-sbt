package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object UseTraitsAsMixins extends App{


  val zeus = new cb008.section4.Dog("Zeus")
  zeus.ownerIsHome
  zeus.jumpForJoy
}

package cb008.section4{
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
