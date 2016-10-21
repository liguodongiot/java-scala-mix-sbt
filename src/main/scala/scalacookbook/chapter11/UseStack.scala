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
  val ints2 = Stack(1, 2, 3)  //前面的元素在栈顶

  println(ints2)
  println(ints2.pop())

  //Once you have a mutable stack, push elements onto the stack with push

  // create a stack
  var fruits = Stack[String]()   //fruits2: scala.collection.mutable.Stack[String] = Stack()
  // add one element at a time
  fruits.push("apple")  //scala.collection.mutable.Stack[String] = Stack(apple)
  fruits.push("banana")   //scala.collection.mutable.Stack[String] = Stack(banana, apple)

  fruits.pop()

  //依次加入栈顶
  // add multiple elements
  fruits.push("coconut", "orange", "pineapple")   //scala.collection.mutable.Stack[String] = Stack(pineapple, orange, coconut, banana, apple)


  println(fruits)

  println("---------------")

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

  //清空栈
  //You can empty a mutable stack with clear.
  fruits.clear

  println(fruits)   //scala.collection.mutable.Stack[String] = Stack()


  //There¡¯s also an ArrayStack class.
  //It provides fast indexing and is generally slightly more efficient
  // for most operations than a normal mutable stack.

  //使用List，而不是使用不可变的栈
  //  Although I haven’t used an immutable Stack, I’ve seen several people recommend using
  //  a List instead of an immutable Stack for this use case. A List has at least one less layer
  //  of code, and you can push elements onto the List with :: and access the first element
  //  with the head method.

}