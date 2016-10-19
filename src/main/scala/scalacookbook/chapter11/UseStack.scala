package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/8/1.
  */
object UseStack extends App{

  //Create an empty, mutable stack of any data type
  import scala.collection.mutable.Stack
  var ints = Stack[Int]()
  var fruits2 = Stack[String]()

  case class Person(var name: String)
  var people = Stack[Person]()


  //You can also populate a stack with initial elements when you create it
  val ints2 = Stack(1, 2, 3)


  //Once you have a mutable stack, push elements onto the stack with push

  // create a stack
  var fruits = Stack[String]()   //fruits2: scala.collection.mutable.Stack[String] = Stack()
  // add one element at a time
  fruits.push("apple")  //scala.collection.mutable.Stack[String] = Stack(apple)
  fruits.push("banana")   //scala.collection.mutable.Stack[String] = Stack(banana, apple)

  // add multiple elements
  fruits.push("coconut", "orange", "pineapple")   //scala.collection.mutable.Stack[String] = Stack(pineapple, orange, coconut, banana, apple)




  //To take elements off the stack, pop them off the top of the stack:

  val next = fruits.pop //next: String = pineapple
  println(fruits)   //scala.collection.mutable.Stack[String] = Stack(orange, coconut, banana, apple)
  //You can peek at the next element on the stack without removing it, using top.
  println(fruits.top)   //String = orange

  // 'orange' is still on the top
  println(fruits) //scala.collection.mutable.Stack[String] = Stack(orange, coconut, banana, apple)

  //Stack extends from Seq, so you can inspect it with the usual methods:
  println(fruits.size)  //Int = 4

  println(fruits.isEmpty) //Boolean = false

  //You can empty a mutable stack with clear.
  println(fruits.clear)

  println(fruits)   //scala.collection.mutable.Stack[String] = Stack()


  //There¡¯s also an ArrayStack class.

}