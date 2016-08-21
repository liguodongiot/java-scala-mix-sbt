package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object DifferentWayCreateList extends App{

  //创建和初始填充列表
  // 1
  val list = 1 :: 2 :: 3 :: Nil   //List[Int] = List(1, 2, 3)

  // 2
  val list2 = List(1, 2, 3)   //List[Int] = List(1, 2, 3)

  // 3a
  val xa = List(1, 2.0, 33D, 4000L)  // List[Double] = List(1.0, 2.0, 33.0, 4000.0)

  // 3b
  val xb = List[Number](1, 2.0, 33D, 4000L)  //List[java.lang.Number] = List(1, 2.0, 33.0, 4000)

  // 4
  val x41 = List.range(1, 10)     //List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val x42 = List.range(0, 10, 2)  //List[Int] = List(0, 2, 4, 6, 8)

  // 5
  val x5 = List.fill(3)("foo")     //List[String] = List(foo, foo, foo)
  // 6
  val x6 = List.tabulate(5)(n => n * n)  //List[Int] = List(0, 1, 4, 9, 16)
  // 7
  val x7 = collection.mutable.ListBuffer(1, 2, 3).toList   //List[Int] = List(1, 2, 3)
  // 8
  "foo".toList     //List[Char] = List(f, o, o)




}
