package scalacookbook.chapter03


import scala.annotation.tailrec


/**
 * Created by liguodong on 2016/6/28.
 */
object CreateYourOwnControlStructure extends App{

  //定义自己的控制结构简化自己的代码，或者创建一个DSL供其他人使用。

  //不想使用while循环，创建whilst循环
  var i = 0
  whilst1(i < 5) {
    println(i)
    i += 1
  }
  // implement this as a method that’s just a wrapper around the while operator
  // 1st attempt
  def whilst1(testCondition: => Boolean)(codeBlock: => Unit) {
    while (testCondition) {
      codeBlock
    }
  }

  println("===============================")


  //implement the whilst method without calling while.
  // 2nd attempt
  @tailrec
  def whilst2(testCondition: => Boolean)(codeBlock: => Unit) {
    if (testCondition) {
      codeBlock
      whilst2(testCondition)(codeBlock)
    }
  }
  i=0
  whilst2(i < 5) {
    println(i)
    i += 1
  }

  //Discussion

  // two 'if' condition tests
  def doubleif(test1: => Boolean)(test2: => Boolean)(codeBlock: => Unit) {
    if (test1 && test2) {
      codeBlock
    }
  }

  val age = 19
  val numAccidents=0
  doubleif(age > 18)(numAccidents == 0) { println("Discount!") }


}


