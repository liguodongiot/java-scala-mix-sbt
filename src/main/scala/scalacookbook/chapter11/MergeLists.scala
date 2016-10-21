package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */

object MergeLists extends App{

  val a = List(1,2,3)
  val b = List(4,5,6)

  val c = a ++ b    // List[Int] = List(1, 2, 3, 4, 5, 6)

  println(c)

  //you may prefer using ::: as a way to create a new list from two existing lists
  val c2 = a ::: b  // List[Int] = List(1, 2, 3, 4, 5, 6)

  println(c2)

  val c3 = List.concat(a, b)  //List[Int] = List(1, 2, 3, 4, 5, 6)

  println(c3)

}
