package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object CreateMultidimensionalArray extends App{

  //Using Array.ofDim
  val rows = 2  //rows: Int = 2
  val cols = 3  //cols: Int = 3

  val a = Array.ofDim[String](rows, cols)
  a(0)(0) = "a"
  a(0)(1) = "b"
  a(0)(2) = "c"
  a(1)(0) = "d"
  a(1)(1) = "e"
  a(1)(2) = "f"

  val x = a(0)(0)
  println(x)

  for {
    i <- 0 until rows
    j <- 0 until cols
  } println(s"($i)($j) = ${a(i)(j)}")

  val x2, y2, z2 = 10
  val a2 = Array.ofDim[Int](x2,y2,z2)
  for {
    i <- 0 until x2
    j <- 0 until y2
    k <- 0 until z2
  } println(s"($i)($j)($k) = ${a2(i)(j)(k)}")

  //Using an array of arrays
  val a3 = Array( Array("a", "b", "c"), Array("d", "e", "f") )
  println(a3(0) )  //res0: Array[String] = Array(a, b, c)
  println(a3(0)(0) ) //res1: String = a

  val a4 = Array(Array("a", "b", "c"), Array("d", "e"))
  var arr = Array(Array("a", "b", "c"))
  arr ++= Array(Array("d", "e"))

  println(arr)


  //Discussion
  val arr2 = Array.ofDim[String](2, 3)
  val arr3 = Array.ofDim[String](2, 2, 2)

  //Scala
  //private final String arr[][];
  //private final String arr[][][];

}
