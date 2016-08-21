package scalacookbook.chapter03

import scala.annotation.tailrec


/**
 * Created by liguodong on 2016/6/28.
 */
object CreateYourOwnControlStructure extends App{

  var i = 0
  whilst (i < 5) {
    println(i)
    i += 1
  }

  // implement this as a method that’s just a wrapper around the while operator
  // 1st attempt
 /* def whilst(testCondition: => Boolean)(codeBlock: => Unit) {
    while (testCondition) {
      codeBlock
    }
  }*/


  //implement the whilst method without calling while.
  // 2nd attempt
  @tailrec
  def whilst(testCondition: => Boolean)(codeBlock: => Unit) {
    if (testCondition) {
      codeBlock
      whilst(testCondition)(codeBlock)
    }
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


