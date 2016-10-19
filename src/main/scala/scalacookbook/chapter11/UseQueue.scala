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



  //Once you have a mutable queue, add elements to it using +=, ++=, and enqueue

  import scala.collection.mutable.Queue
  // create an empty queue
  var q2 = new Queue[String]

  // add elements to the queue in the usual ways
  var q3 = new Queue[String]

  q3 += "apple" //scala.collection.mutable.Queue[String] = Queue(apple)

  q3 += ("kiwi", "banana") //scala.collection.mutable.Queue[String] = Queue(apple, kiwi, banana)
  q3 ++= List("cherry", "coconut") //scala.collection.mutable.Queue[String] = Queue(apple, kiwi, banana, cherry, coconut)


  // can also use enqueue
  q3.enqueue("pineapple")
  println(q3)  //scala.collection.mutable.Queue[String] = Queue(apple, kiwi, banana, cherry, coconut, pineapple)


  // a queue is a FIFO, you typically remove elements
  // from the head of the queue, one element at a time, using dequeue
  // take an element from the head of the queue
  val next = q3.dequeue
  // 'apple' is removed from the queue
  println(q3)   //scala.collection.mutable.Queue[String] = Queue(kiwi, banana, cherry, coconut, pineapple)

  // take the next element
  val next2 = q3.dequeue  //String = kiwi

  // 'kiwi' is removed from the queue
  println(q3)   //scala.collection.mutable.Queue[String] = Queue(banana, cherry, coconut, pineapple)



  //You can also use the dequeueFirst and dequeueAll methods to
  // remove elements from the queue by specifying a predicate
  q3.dequeueFirst(_.startsWith("b"))   //Option[String] = Some(banana)
  println(q3)

  q3.dequeueAll(_.length > 6)
  println(q3)


}
