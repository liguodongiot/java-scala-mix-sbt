package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object AddElementToSet extends App{

  // use var with mutable 创建空的set
  var set = scala.collection.mutable.Set[Int]()

  // add one element
  set += 1   //scala.collection.mutable.Set[Int] = Set(1)

  // add multiple elements
  set += (2, 3)
  println(set)  //Set(1, 2, 3)

  // notice that there is no error when you add a duplicate element
  set += 2
  println(set) //Set(1, 2, 3)

  // add elements from any sequence (any TraversableOnce)
  set ++= Vector(4, 5) //scala.collection.mutable.Set[Int] = Set(2, 1, 4, 3, 5)
  println(set)

  set.add(6) //Boolean = true
  set.add(5) //Boolean = false
  println(set)

  //测试set集合中是否包含该元素
  set.contains(5)

  //创建包含元素的set
  var set2 = scala.collection.mutable.Set(1, 2, 3)

  //Immutable set

  //create an immutable set
  val s1 = Set(1, 2)

  // add one element
  val s2 = s1 + 3

  // add multiple elements (+ method has a varargs field)
  val s3 = s2 + (4, 5)

  // add elements from another sequence
  val s4 = s3 ++ List(6, 7)

  // declare your variable as a var,
  // and reassign the resulting set back to the same variable
  var set3 = Set(1, 2, 3)  //scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  set3 += 4
  println(set3)

}
