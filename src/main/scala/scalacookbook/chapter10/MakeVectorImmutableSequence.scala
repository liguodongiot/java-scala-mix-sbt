package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object MakeVectorImmutableSequence extends App{

  //快速、通用、不变集合

  val v = Vector("a", "b", "c")
  println(v(0))

  val a = Vector(1, 2, 3)

  //因为不可修改，如果想增加元素，需将结果保存到新的变量
  val b = a ++ Vector(4, 5)

  //更新元素到一个新变量
  //Use the updated method to replace one element in a Vector
  val c = b.updated(0, "x")

  c.foreach(println)

  println("~~~~~~~~~~~~~~~~~")

  val a2 = Vector(1, 2, 3, 4, 5)

  val b2 = a2.take(2)
  b2.foreach(println)

  println("~~~~~~~~~~~~~~~~~")

  val c2 = a2.filter(_ > 2)
  c2 foreach println

  println("=================")

  //you can also declare your variable as a var
  // and reassign the result back to the same variable
  var a3 = Vector(1, 2, 3)
  a3 = a3 ++ Vector(4, 5)
  println(a3.mkString(", "))

  //Vector is the most flexible, efficient collection
  //in the Scala collections library.

  //if you create an instance of an IndexedSeq, Scala returns a Vector
  val x = IndexedSeq(1,2,3)

  println(x)

  //As a result, I’ve seen some developers create an IndexedSeq in their code, rather than a Vector,
  // 为了更加通用和允许将来潜在的变化。

}
