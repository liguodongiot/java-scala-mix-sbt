package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/8/1.
  */
object UseQueue extends App {

  class Person (var name: String)

  import scala.collection.mutable.Queue
  var ints = Queue[Int]()
  var fruits = Queue[String]()
  var q = Queue[Person]()

  val qInt = Queue(1, 2, 3)
  println(qInt)


  //Once you have a mutable queue, add elements to it using +=, ++=, and enqueue

  import scala.collection.mutable.Queue
  // create an empty queue 空的可变队列
  var q2 = new Queue[String]

  // add elements to the queue in the usual ways

  q2 += "apple" //scala.collection.mutable.Queue[String] = Queue(apple)
  q2 += ("kiwi", "banana") //scala.collection.mutable.Queue[String] = Queue(apple, kiwi, banana)
  q2 ++= List("cherry", "coconut") //scala.collection.mutable.Queue[String] = Queue(apple, kiwi, banana, cherry, coconut)

  // can also use enqueue
  q2.enqueue("pineapple")
  println(q2)  //scala.collection.mutable.Queue[String] = Queue(apple, kiwi, banana, cherry, coconut, pineapple)

  println("------------")

  // a queue is a FIFO, you typically remove elements
  // from the head of the queue, one element at a time, using dequeue
  // take an element from the head of the queue
  val next = q2.dequeue
  // 'apple' is removed from the queue
  println(q2)   //scala.collection.mutable.Queue[String] = Queue(kiwi, banana, cherry, coconut, pineapple)
  println(next)

  // take the next element
  val next2 = q2.dequeue  //String = kiwi

  // 'kiwi' is removed from the queue
  println(q2)   //scala.collection.mutable.Queue[String] = Queue(banana, cherry, coconut, pineapple)
  println(next2)

  //You can also use the dequeueFirst and dequeueAll methods to
  // remove elements from the queue by specifying a predicate
  q2.dequeueFirst(_.startsWith("p"))   //Option[String] = Some(banana)
  println(q2)

  q2.dequeueAll(_.length > 6)
  println(q2)

  //A Queue is a collection class that extends from Iterable and Traversable,
  // so it has all the usual collection methods, including foreach, map, etc.

}
