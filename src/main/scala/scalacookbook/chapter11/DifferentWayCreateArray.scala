package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object DifferentWayCreateArray extends App{

  val a = Array(1,2,3)

  val fruits = Array("Apple", "Banana", "Orange")

  // scala makes this Array[Double]
  val xx = Array(1, 2.0, 33D, 400L)       //xx: Array[Double] = Array(1.0, 2.0, 33.0, 400.0)

  // manually override the type
  val xx2 = Array[Number](1, 2.0, 33D, 400L)    //xx2: Array[Number] = Array(1, 2.0, 33.0, 400)

  // create an array with an initial size
  val fruits2 = new Array[String](3)

  // somewhere later in the code ...
  fruits2(0) = "Apple"
  fruits2(1) = "Banana"
  fruits2(2) = "Orange"

  println(fruits2.toList)

  //初始化为NULL，生产环境不建议这样操作
  // this uses a null. don't do this in the real world
  var fruits3: Array[String] = _
  // later ...
  fruits3 = Array("apple", "banana")

  println(fruits3.toList)

  val x = Array.range(1, 10)

  val x2 = Array.range(0, 10, 2)

  val x3 = Array.fill(3)("foo") // Array[String] = Array(foo, foo, foo)

  val x4 = Array.tabulate(5)(n => n * n)  //Array[Int] = Array(0, 1, 4, 9, 16)

  val x5 = List(1, 2, 3).toArray

  "Hello".toArray //Array[Char] = Array(H, e, l, l, o)

  val aa = Array(1, 2, 3)

  aa(0) = 10
  aa(1) = 20
  aa(2) = 30

  println(aa.toList)

}
