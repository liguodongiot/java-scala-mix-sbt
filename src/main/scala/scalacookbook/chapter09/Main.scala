package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object Main extends App{

  val a=0
  val b=11
  val greater = if (a > b) a else b

  val aString = "213"
  val result = try {
    aString.toInt
  } catch {
    case _ => 0
  }


}
