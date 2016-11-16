package scalacookbook.chapter13

import scala.collection.parallel.mutable.ParArray

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
  println("\n~~~~~~~~~~~~")

  //并行集合
  //create a parallel collection directly
  import scala.collection.parallel.immutable.ParVector
  val v2 = ParVector.range(0, 10)
  v2.foreach{ e => Thread.sleep(100); print(e) }

  //一些不可变的并行集合
  //list of some of the immutable parallel collection classes:
  //ParHashMap ParHashSet ParIterable ParMap ParRange ParSeq ParSet ParVector

  //可变的并行集合
  //the mutable collection has other classes and traits, including ParArray

  //您的算法接收任意顺序的元素
  // sum, max, min, mean, and filter适合用并行集合

  println("\n---------")
  //Where are parallel collections useful?
  val v3 = ParVector.range(0, 10)
  v3.foreach{ e => Thread.sleep(100); print(e) }

  println("\n=========")

  var v4 = ParArray.range(4,7)
  v4.foreach{ e => Thread.sleep(100); print(e) }

  println("\n---------")
  v4  ++=  Array(1,2,3);
  v4.foreach{ e => Thread.sleep(100); print(e) }
  //当数据量大时，使用并行集合速度是明显的，
  //如果并行集合不能解决你的问题，使用Akka actor和Future让你完成控制你的算法。

}
