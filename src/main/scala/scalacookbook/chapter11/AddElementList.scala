package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object AddElementList extends App{

  //because a List is immutable, so you can’t actually add elements to it.
  // If you want a List that is constantly changing,
  // use a ListBuffer (as described in Recipe 11.2),
  // and then convert it to a List when necessary.


  // assigning the results to a new List
  val x = List(2)
  val y = 1 :: x // List[Int] = List(1, 2)
  val z = 0 :: y // List[Int] = List(0, 1, 2)

  println(z)

  var xx = List(2)
  xx = 1 :: xx    //List[Int] = List(1, 2)
  xx = 0 :: xx    //List[Int] = List(0, 1, 2)

  println(xx)

  val list1 = 3 :: Nil
  val list2 = 2 :: list1
  val list3 = 1 :: list2

  println(list3)

  //
  val f1 = new Printer
  f1 >> 42
  42 >>: f1

  f1.>>(42)
  f1.>>:(42)

  val ax = List(1)
  val ay = 0 +: ax  //List(0, 1)

  println(ay)

  //ax不可变

  val ay2 = ax :+ 2 //List(1, 2)

  println(ay2)

}


class Printer {
  def >>(i: Int) { println(s"$i") }
  def >>:(i: Int) { println(s"$i") }
}