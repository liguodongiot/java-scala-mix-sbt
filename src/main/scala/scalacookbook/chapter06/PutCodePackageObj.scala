package scalacookbook.chapter06

import model._

/**
 * Created by liguodong on 2016/7/9.
 */


object PutCodePackageObj extends App{

  // access our method, constant, and enumeration
  echo("Hello, world")
  echo(MAGIC_NUM)
  echo(Margin.LEFT)

  // use our MutableMap type (scala.collection.mutable.Map)
  val mm = MutableMap("name" -> "Al")
  mm += ("password" -> "123")
  for ((k,v) <- mm) printf("key: %s, value: %s\n", k, v)


}


package object model {
  // field
  val MAGIC_NUM = 42

  // method
  def echo(a: Any) { println(a) }

  // enumeration
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }

  // type definition
  type MutableMap[K, V] = scala.collection.mutable.Map[K, V]
  val MutableMap = scala.collection.mutable.Map
}
