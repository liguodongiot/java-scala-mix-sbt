package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/12.
 */
object OverrideDefaultNum extends App{
  //default
  val a1 = 1d

  //override simple numeric types
  val a2 = 1d
  val a3 = 1f
  val a4 = 1000L

  //另一种方法是用一个类型来注释变量
  val a5 = 0: Byte
  val a6 = 0: Int
  val a7 = 0: Short
  val a8 = 0: Double
  val a9 = 0: Float

  //冒号后面的空格并不重要
  val a10 = 0:Byte

  //specifying the type after the variable name
  val a11:Byte = 0
  val a12:Int = 0


  //You can create hex values by preceding the number with a leading 0x or 0X
  val a13 = 0x20
  // if you want to store the value as a Long
  val a14 = 0x20L

  val s = "Dave"
  val p = s: Object


  // general case
  //var [name]:[Type] = [initial value]

  // example
  var a:Short = 0



  var name = null.asInstanceOf[String]
  println(name)
}

class Foo {
  var a: Short = 0 // specify a default value
  var b: Short = _ // defaults to 0
}