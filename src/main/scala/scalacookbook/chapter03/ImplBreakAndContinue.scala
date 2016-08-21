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


  println("~~~~~~~~~~~~~~~~~~~~~~")


  import scala.util.control._
  val Inner = new Breaks
  val Outer = new Breaks

  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j")
          if (i == 2 && j == 'b') Outer.break
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

  //If you don’t like using break and continue,
  //there are several other ways to attack these problems.

  /*
  var barrelIsFull = false
  for (monkey <- monkeyCollection if !barrelIsFull) {
    addMonkeyToBarrel(monkey)
    barrelIsFull = checkIfBarrelIsFull
  }
  */


  //Another approach is to place your algorithm inside a function, and then return from
  //the function when the desired condition is reached.

  /*
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
  */


  //A common approach in functional programming is to use recursive algorithms.
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }


  //A more optimal solution takes advantage of tail recursion
  import scala.annotation.tailrec
  def factorial2(n: Int): Int = {
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1) acc
      else factorialAcc(n * acc, n - 1)
    }
    factorialAcc(1, n)
  }


}