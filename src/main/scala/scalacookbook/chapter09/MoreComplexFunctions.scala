package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object MoreComplexFunctions extends App{

  def exec(callback: Int => Unit) {
    // invoke the function we were given, giving it an Int parameter
    callback(1)
  }

  val plusOne = (i: Int) => { println(i+1) }

  exec(plusOne)

  val plusTen = (i: Int) => { println(i+10) }

  exec(plusTen) // prints 11


  //Discussion

  //describing a function as a method parameter
  //parameterName: (parameterType(s)) => returnType


  def executeFunction(f:(String) => Int){
    f("110")
  }

  // parentheses are optional when the function has only one parameter
  def executeFunction2(f:String => Int){
    f("120")
  }

  //To define a function that takes two Ints and returns a Boolean
  def executeFunction(f:(Int, Int) => Boolean): Unit ={
    f(1,2)
  }

  //The following exec method expects a function that takes String, Int, and Double
  //  parameters and returns a Seq[String]
  def exec(f:(String, Int, Double) => Seq[String]){
    f("12",1,32.2D)
  }

  def exec2(f:(Int) => Unit): Unit ={
    f(2)
  }
  def exec3(f:Int => Unit): Unit ={
    f(3)
  }


  //Passing in a function with other parameters

  val sayHello = () => println("Hello")

  //define a method that takes this function as a parameter
  // and also takes a second Int parameter
  def executeXTimes(callback:() => Unit, numTimes: Int) {
    for (i <- 1 to numTimes) callback()
  }

  executeXTimes(sayHello, 3)

  //create a method named executeAndPrint that takes a function
  // and two Int parameters
  def executeAndPrint(f:(Int, Int) => Int, x: Int, y: Int) {
    val result = f(x, y)
    println(result)
  }

  //val result = f(x, y)
  val sum = (x: Int, y: Int) => x + y
  val multiply = (x: Int, y: Int) => x * y

  executeAndPrint(sum, 2, 9) // prints 11
  executeAndPrint(multiply, 3, 9) // prints 27


  //Here’s one more example of this three-step process.

  // 1 - define the method
  def exec(callback: (Any, Any) => Unit, x: Any, y: Any) {
    callback(x, y)
  }
  // 2 - define a function to pass in
  val printTwoThings =(a: Any, b: Any) => {
    println(a)
    println(b)
  }
  // 3 - pass the function and some parameters to the method
  case class Person(name: String)
  exec(printTwoThings, "Hello", Person("Dave"))


  // 2a - define a method to pass in
  def printTwoThings2 (a: Any, b: Any) {
    println(a)
    println(b)
  }
  // 3a - pass the printTwoThings method to the exec method
  case class Person2(name: String)
  exec(printTwoThings2, "Hello", Person2("Dave"))

}
