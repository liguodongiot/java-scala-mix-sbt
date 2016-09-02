package scalacookbook.chapter03



import util.control.Breaks._
/**
 * Created by liguodong on 2016/6/28.
 */
object ImplBreakAndContinue extends App{

  println("\n=== BREAK EXAMPLE ===")

  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break // break out of the for loop
    }
  }

  println("\n=== CONTINUE EXAMPLE ===")
  val searchMe = "peter piper picked a peck of pickled peppers"
  var numPs = 0

  for (i <- 0 until searchMe.length) {
    breakable {
      if (searchMe.charAt(i) != 'p') {
        break // break out of the 'breakable', continue the outside loop
      } else {
        numPs += 1
      }
    }
  }

  println("Found " + numPs + " p's in the string.")

  //use the count method with a simple anonymous function
  val count = searchMe.count(_ == 'p')
  println("count : " + count)

  println("------------")


  import scala.util.control._
  val Inner = new Breaks
  val Outer = new Breaks

  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j")  //相当于continue
          if (i == 2 && j == 'b') Outer.break //相当于break
        }
      }
    }
  }

  //Use the same approach if you prefer labeled breaks.
  import scala.util.control._
  val Exit = new Breaks

  Exit.breakable {
    for (j <- 'a' to 'e') {
      if (j == 'c') Exit.break else println(s"j: $j")
    }
  }


  println("~~~~~~~~~~~~~~")

  //其他方式跳出循环
  //If you don’t like using break and continue,
  //there are several other ways to attack these problems.

  val monkeyCollection = 1.to(10)

  var barrelIsFull = false
  for (monkey <- monkeyCollection if !barrelIsFull) {
    println(monkey)
    barrelIsFull = checkIfEqualFive(monkey.toInt)
  }

  def checkIfEqualFive(n:Int):Boolean = {
    if(n==5)
      true
    else
      false
  }

  //另外一个方式就是当满足条件，通过return结束。
  //Another approach is to place your algorithm inside a function, and then return from
  //the function when the desired condition is reached.


  // calculate a sum of numbers, but limit it to a 'max' value
  def sumToMax(arr: Array[Int], limit: Int): Int = {
    var sum = 0
    for (i <- arr) {
      sum += i
      if (sum > limit) return limit
    }
    sum
  }

  val a = Array.range(0,10)
  println(sumToMax(a, 10))

  println("---------递归--------------")

  //使用递归算法
  //A common approach in functional programming is to use recursive algorithms.
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n + factorial(n - 1)
  }

  import com.github.nscala_time.time.Imports._
  //println(factorial(1000))
  val start1 = DateTime.now()
  println(factorial(1000))
  val end1 = DateTime.now()
  //获取毫秒
  println(start1.getMillis+" "+end1.getMillis)
  println("未使用尾递归："+(end1.getMillis-start1.getMillis))

  //一个最佳的方案，使用尾递归。尤其是起始值N非常大时。

  //尾递归和一般的递归不同在对内存的占用，
  //普通递归创建stack累积而后计算收缩，尾递归只会占用恒量的内存（和迭代一样）。

  //尾递归是把变化的参数传递给递归函数的变量了。

  //A more optimal solution takes advantage of tail recursion
  import scala.annotation.tailrec
  def factorial2(n: Int): Int = {
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1) acc
      else factorialAcc(n + acc, n - 1)
    }
    factorialAcc(1, n)
  }
  //使用@tailrec注解，确保使用的算法是尾递归，如果使用的算法不是尾递归，就会报错。

  import com.github.nscala_time.time.Imports._
  val start2 = DateTime.now()
  println(factorial2(1000))
  val end2 = DateTime.now()
  println("使用尾递归："+(end2.getMillis-start2.getMillis))
}