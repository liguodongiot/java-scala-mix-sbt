package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object UnderstandCollectionHierarchy extends App{

  val v = Vector(1, 2, 3)
  println(v.sum)// 6
  println(v.filter(_ > 1)) // Vector(2, 3)
  println(v.map(_ * 2)) // Vector(2, 4, 6)

  //Sequences
  val x = IndexedSeq(1,2,3)
  println(x)

  val seq = scala.collection.immutable.LinearSeq(1,2,3)
  println(seq)


  //Maps
  //When you just need a simple,
  //immutable map, you can create one without requiring an import.

  val m = Map(1 -> "a", 2 -> "b")

  val m2 = collection.mutable.Map(1 -> "a", 2 -> "b")



  //Sets
  val s = collection.mutable.Set(1, 2, 3)


}
