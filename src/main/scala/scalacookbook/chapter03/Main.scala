package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/18.
 */

object Main extends App{

  //val x = if (a) y else z
  val nieces = List("emily", "hannah", "mercedes", "porsche")
  println(nieces)

  for (n <- nieces) yield println(n.capitalize+" ")



}
