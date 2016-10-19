package scalacookbook.chapter19

/**
  *
  * the following code shows how a callSpeak method can require that its
  * obj type parameter have a speak() method
  *
  * Created by liguodong on 2016/8/22.
  */

/*
def callSpeak[A <: { def speak(): Unit }](obj: A) {
  // code here ...
  obj.speak()
}
*/

package section03{
  class Dog { def speak() { println("woof") } }

  class Klingon { def speak() { println("Qapla!") } }
}


object DuckTyping extends App {
  import section03._

  def callSpeak[A <: { def speak(): Unit }](obj: A) {
    obj.speak()
  }

  callSpeak(new Dog)
  callSpeak(new Klingon)

  // <: upper bound
}