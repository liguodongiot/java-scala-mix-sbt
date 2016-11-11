package scalacookbook.chapter13

/**
  * Created by liguodong on 2016/8/14.
  */
object UseParallelCollection extends App {

  val v = Vector.range(0, 10)
  v.foreach(print)
  println("\n---------")

  //call the par method on your collection to turn it into a parallel collection,
  v.par.foreach(print)
  println("\n---------")
  v.par.foreach(print)
  println("\n---------")
  v.par.foreach{ e => print(e); Thread.sleep(50) }
  println("\n---------")

  //create a parallel collection directly
  import scala.collection.parallel.immutable.ParVector
  val v2 = ParVector.range(0, 10)
  v2.foreach{ e => Thread.sleep(100); print(e) }


  //list of some of the immutable parallel collection classes:
  //ParHashMap ParHashSet ParIterable ParMap ParRange ParSeq ParSet ParVector

  //the mutable collection has other classes and traits, including ParArray
  println("\n---------")
  //Where are parallel collections useful?
  val v3 = ParVector.range(0, 10)
  v3.foreach{ e => Thread.sleep(100); print(e) }

}
