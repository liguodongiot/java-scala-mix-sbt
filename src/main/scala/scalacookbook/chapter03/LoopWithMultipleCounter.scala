package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/23.
 */
object LoopWithMultipleCounter extends App{

  for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")

  // When doing this, the preferred style for multiline
  // for loops is to use curly brackets:
  for {
    i <- 1 to 2
    j <- 1 to 2
  } println(s"i = $i, j = $j")


  //Similarly, you can use three counters like this:
  for {
    i <- 1 to 3
    j <- 1 to 5
    k <- 1 to 10
  } println(s"i = $i, j = $j, k = $k")


  // This is useful when looping over a multidimensional array.
  // Assuming you create a small two-dimensional array like this:
  val array = Array.ofDim[Int](2,2)
  array(0)(0) = 0
  array(0)(1) = 1
  array(1)(0) = 2
  array(1)(1) = 3

  //you can print each element of the array like this:
  for {
    i <- 0 to 1
    j <- 0 to 1
    } println(s"($i)($j) = ${array(i)(j)}")


}
