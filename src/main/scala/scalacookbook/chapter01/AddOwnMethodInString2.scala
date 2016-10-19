package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/7.
 */

object AddOwnMethodInString2 {

  //Using versions of Scala prior to version 2.10
  implicit def stringToString(s: String) = new StringImprovements(s)

  def main(args: Array[String]) {
    println("HAL".increment)

  }

}




//Using versions of Scala prior to version 2.10
class StringImprovements(val s: String) {
  def increment = s.map(c => (c + 1).toChar)
}
