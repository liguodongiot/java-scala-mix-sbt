package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/30.
  */
object TuplesWhenJustNeedBag extends App{

  val d = ("Debi", 95)
  println(d)

  case class Person(name: String)

  val t = (3, "Three", new Person("Al"))
  println(t._1)
  println(t._2)
  println(t._3)

  val (xx, yy, zz) = (3, "Three", new Person("Al"))
  println("[" + xx + ":" + yy  + ":" + zz + "]")


  val (xx2, yy2, _) = t
  println("[" + xx2 + ":" + yy2  + "]")


  val (xx3, _, _) = t
  println("[" + xx3  + "]")

  val (xx4, _, zz4) = t
  println("[" + xx4 + ":" + zz4  + "]")


  //A two-element tuple is an instance of the Tuple2 class,
  // and a tuple with three elements is an instance of the Tuple3 class.
  val a = ("AL", "Alabama")

  val b = "AL" -> "Alabama"

  val c = ("AL" -> "Alabama")


  println(""+ a.getClass +" : "+ b.getClass +" : "+c.getClass)



  //This syntax is very convenient for other uses, including the creation of maps
  val map = Map("AL" -> "Alabama")

  println(map)

  //Discussion
  val x = ("AL" -> "Alabama")

  println(x)

  val it = x.productIterator // Iterator[Any] = non-empty iterator

  for (e <- it) println(e)

  println("-------------------")

  //Attempting to print the elements a second time yields no output
  for (e <- it) println(e) // no output here

  println("-------------------")

  //如果想循环第二次的话，创建一个新的迭代器
  //Create a new iterator if you need to loop over the elements a second time.
  //或者转换成一个集合
  //You can also convert a tuple to a collection.
  val t2 = ("AL", "Alabama")

  println(t2.productIterator.toArray) //Array[Any] = Array(AL, Alabama)
  println(t2.productIterator.toList)

}
