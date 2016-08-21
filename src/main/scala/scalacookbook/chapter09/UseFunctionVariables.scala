package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object UseFunctionVariables extends App{

  val double = (i: Int) => { i * 2 }
  println(double(2))
  println(double(3))
  val list = List.range(1, 5)

  list.map(double).foreach(print)
  println()
  println("~~~~~")

  //Discussion
  val f = (i: Int) => { i % 2 == 0 }

  val f2: (Int) => Boolean = i => { i % 2 == 0 }
  val f3: Int => Boolean = i => { i % 2 == 0 }
  val f4: Int => Boolean = i => i % 2 == 0
  val f5: Int => Boolean = _ % 2 == 0



  // implicit approach
  val add = (x: Int, y: Int) => { x + y }
  val add2 = (x: Int, y: Int) => x + y

  // explicit approach
  val add3: (Int, Int) => Int = (x,y) => { x + y }
  val add4: (Int, Int) => Int = (x,y) => x + y


  val addThenDouble: (Int, Int) => Int = (x,y) => {
    val a = x + y
    2 * a
  }

  //Using a method like an anonymous function

  def modMethod(i: Int) = i % 2 == 0
  def modMethod2(i: Int) = { i % 2 == 0 }
  //:之前是参数 之后是返回类型
  def modMethod3(i: Int): Boolean = i % 2 == 0
  def modMethod4(i: Int): Boolean = { i % 2 == 0 }

  val list2 = List.range(1, 10)
  list2.filter(modMethod).foreach(print)
  println
  println("~~~~~")

  //Assigning an existing function/method to a function variable
  val c = scala.math.cos _
  val c2 = scala.math.cos(_)

  println(c(0))


  val p = scala.math.pow(_, _)
  println(p(scala.math.E, 2))

}
