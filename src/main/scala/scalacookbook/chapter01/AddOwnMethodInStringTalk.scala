package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/7.
 */
object AddOwnMethodInStringTalk extends App{

  import StringAddMethod._
  println("HAL".increment)
  println("hello.ool...ood".hideAll)
  println("4".plusOne)
  println("0".asBoolean)
  println("1".asBoolean)




}


object StringAddMethod{

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)

    // being explicit that each method returns a String
    def decrement: String = s.map(c => (c - 1).toChar)
    def hideAll: String = s.replaceAll(".", "*")
    //Returning other types
    def plusOne = s.toInt + 1
    def asBoolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }


  }
}

