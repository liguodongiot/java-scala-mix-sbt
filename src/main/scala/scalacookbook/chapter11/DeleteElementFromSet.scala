package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/8/1.
  */
object DeleteElementFromSet extends App{

  //Mutable set
  var set = scala.collection.mutable.Set(1, 2, 3, 4, 5)

  // one element
  set -= 1

  // two or more elements (-= has a varags field)
  set -= (2, 3)

  // multiple elements defined in another sequence
  set --= Array(4,5)


  //You can also use other methods like retain, clear, and remove
  // retain
  var set2 = scala.collection.mutable.Set(1, 2, 3, 4, 5)//scala.collection.mutable.Set[Int] = Set(2, 1, 4, 3, 5)
  set2.retain(_ > 2)
  println(set2) //scala.collection.mutable.Set[Int] = Set(4, 3, 5)

  // clear
  var set3 = scala.collection.mutable.Set(1, 2, 3, 4, 5)//scala.collection.mutable.Set[Int] = Set(2, 1, 4, 3, 5)
  set3.clear
  println(set3) //scala.collection.mutable.Set[Int] = Set()


  // remove
  var set4 = scala.collection.mutable.Set(1, 2, 3, 4, 5) //scala.collection.mutable.Set[Int] = Set(2, 1, 4, 3, 5)
  set4.remove(2)   //Boolean = true
  println(set4)    //scala.collection.mutable.Set[Int] = Set(1, 4, 3, 5)
  set4.remove(40)  //Boolean = false

  //As shown, the remove method provides feedback as to
  // whether or not any elements were removed.

  //Immutable set
  val s1 = Set(1, 2, 3, 4, 5, 6)  //scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)

  // one element
  val s2 = s1 - 1   //scala.collection.immutable.Set[Int] = Set(5, 6, 2, 3, 4)

  // multiple elements
  val s3 = s2 - (2, 3)  //scala.collection.immutable.Set[Int] = Set(5, 6, 4)

  // multiple elements defined in another sequence
  val s4 = s3 -- Array(4, 5)  //scala.collection.immutable.Set[Int] = Set(6)



  //use all of the filtering methods
  val s5 = Set(1, 2, 3, 4, 5, 6)  //scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)

  val s6 = s5.filter(_ > 3)   //scala.collection.immutable.Set[Int] = Set(5, 6, 4)

  val firstTwo = s5.take(2)   //scala.collection.immutable.Set[Int] = Set(5, 1)


}
