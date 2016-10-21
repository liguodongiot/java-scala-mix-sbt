package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/8/1.
  */
object UseRange extends App{

  println(1 to 10)

  println(1 until 10)

  println(1 to 10 by 2)

  println( 'a' to 'c')

  //you can use ranges to create and populate sequences:
  val x = (1 to 10).toList
  println(x)

  val x2 = (1 to 10).toArray   //Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val x3 = (1 to 10).toSet    //scala.collection.immutable.Set[Int] = Set(5, 10, 1, 6, 9, 2, 7, 3, 8, 4)

  //Some sequences have a range method in their objects to perform the same function.

  val x4 = Array.range(1, 10)  //Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

  val x5 = Vector.range(1, 10)  //collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9)

  val x6 = List.range(1, 10)    //List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  val x7 = List.range(0, 10, 2)   //List[Int] = List(0, 2, 4, 6, 8)

  val x8 = collection.mutable.ArrayBuffer.range('a', 'd') //scala.collection.mutable.ArrayBuffer[Char] = ArrayBuffer(a, b, c)

  for (i <- 1 to 3) println(i)

  //Discussion
  //a Range can be combined with the map method to populate a collection

  //range结合map方法
  val x9 = (1 to 5).map { e => (e + 1.1) * 2 }
  println(x9)

  // 0~4
  val x10 = List.tabulate(5)(_ + 1) //List[Int] = List(1, 2, 3, 4, 5)

  val x11 = List.tabulate(5)(_ + 2) //List[Int] = List(2, 3, 4, 5, 6)

  val x12 = Vector.tabulate(5)(_ * 2) //scala.collection.immutable.Vector[Int] = Vector(0, 2, 4, 6, 8)

}
