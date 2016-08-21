package scalacookbook.chapter08

/**
  * Created by liguodong on 2016/7/21.
  */
object AddTraitToObjectInstance extends App{

  val hulk = new DavidBanner with Angry

  ///////////////////////////////

  // no debugger
  val child = new Child
  // debugger added as the object is created
  val problemChild = new ProblemChild with Debugger

}
class DavidBanner
trait Angry {
  println("You won't like me ...")
}

/////////////////////
class Child
class ProblemChild
trait Debugger {
  def log(message: String) {
    // do something with message
  }
}
