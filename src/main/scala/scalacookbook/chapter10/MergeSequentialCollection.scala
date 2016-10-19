package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/27.
  */
object MergeSequentialCollection extends App{

  val a = collection.mutable.ArrayBuffer(1,2,3)

  a ++= Seq(4,5,6)

  a.foreach(x=>print(x+" "))

  println("~~~~~~~~~~~~~~~~~")

  val aa = Array(1,2,3)

  val bb = Array(4,5,6)
  val cc = aa ++ bb
  cc.foreach(x=>print(x+" "))

  println("~~~~~~~~~~~~~~~~~")

  val a2 = Array(1,2,3,4,5)
  val b2 = Array(4,5,6,7,8)
  // elements that are in both collections
  val c2 = a2.intersect(b2)  // Array(4, 5)

  // all elements from both collections
  val c3 = a2.union(b2) //Array(1, 2, 3, 4, 5, 4, 5, 6, 7, 8)

  // distinct elements from both collections
  val c4 = a2.union(b2).distinct

  val c5 = a2 diff b2 //Array(1, 2, 3)
  val c6 = b2 diff a2 //Array(6, 7, 8)

  Array.concat(a2, b2).foreach(x=>print(x+" "))

  println("~~~~~~~~~~~~~~~~~")

  val a3 = List(1,2,3,4)
  val b3 = List(4,5,6,7)

  val ca = a3 ::: b3
  println(ca)

  //Discussion
  val ak = Array(1,2,3,11,4,12,4,5)
  val bk = Array(6,7,4,5)

  // the elements in a that are not in b
  val ck = ak.toSet diff bk.toSet //ck: scala.collection.immutable.Set[Int] = Set(1, 2, 12, 3, 11)

  // the elements in b that are not in a
  val dk = bk.toSet diff ak.toSet  //dk: scala.collection.immutable.Set[Int] = Set(6, 7)

  val complement = ck ++ dk   //complement: scala.collection.immutable.Set[Int] = Set(1, 6, 2, 12, 7, 3, 11)

  val cv = ak.toSet -- bk.toSet //Set(1, 2, 12, 3, 11)

  val ds = bk.toSet -- ak.toSet //Set(6, 7)

  //交集
  val i = ak.intersect(bk)      //i: Array[Int] = Array(4, 5)

  val cl = ak.toSet -- i.toSet  //cl: scala.collection.immutable.Set[Int] = Set(1, 2, 12, 3, 11)
  val dl = bk.toSet -- i.toSet  //dl: scala.collection.immutable.Set[Int] = Set(6, 7)



}
