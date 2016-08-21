package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */

class Person

object UseIfATernaryOperator extends App{
  val a = -1

  val absValue = if (a < 0) -a else a

  var i = 0
  println(if (i == 0) "a" else "b")

  val name = "liguodong"
  var hash = 0
  val prime = 0
  hash = hash * prime + (if (name == null) 0 else name.hashCode)


  def abs(x: Int) = if (x >= 0) x else -x

  def max(a: Int, b: Int) = if (a > b) a else b

  val a2=0
  val b2=0
  val c = if (a2 > b2) a2 else b2


}


