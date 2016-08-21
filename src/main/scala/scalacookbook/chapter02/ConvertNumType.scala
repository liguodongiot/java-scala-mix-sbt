package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/11.
 */
object ConvertNumType extends App{

  //val b = a.to[Tab]
  println(19.45.toInt)
  println(19.toFloat)
  println(19.toDouble)
  println(19.toLong)


  val a = 1000L


  println(a.isValidByte)
  println(a.isValidShort)


}
