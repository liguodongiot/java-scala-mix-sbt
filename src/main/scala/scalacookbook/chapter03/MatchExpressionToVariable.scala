package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */
object MatchExpressionToVariable extends App{

  val someNumber = 9
  val evenOrOdd = someNumber match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }


  def isTrue(a: Any) = a match {
    case 0 | "" => false
    case _ => true
  }

  println(isTrue(""))
  println(isTrue("liguodong"))



}
