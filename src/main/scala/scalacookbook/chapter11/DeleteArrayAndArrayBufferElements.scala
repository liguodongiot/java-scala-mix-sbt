package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object DeleteArrayAndArrayBufferElements extends App{

  import scala.collection.mutable.ArrayBuffer
  val x = ArrayBuffer('a', 'b', 'c', 'd', 'e')
  // remove one element
  x -= 'a'
  // remove multiple elements (methods defines a varargs param)
  x -= ('b', 'c')

  println(x)

  val x2 = ArrayBuffer('a', 'b', 'c', 'd', 'e')
  x2 --= Seq('a', 'b')
  x2 --= Array('c')
  x2 --= Set('d')

  println(x2)

  val x3 = ArrayBuffer('a', 'b', 'c', 'd', 'e', 'f')
  x3.remove(0)  //res0: Char = a
  println(x3)    //scala.collection.mutable.ArrayBuffer[Char] = ArrayBuffer(b, c, d, e, f)

  x3.remove(1, 3)
  println(x3)    //scala.collection.mutable.ArrayBuffer[Char] = ArrayBuffer(b, f)

  println("--------------")

  //清空
  var a = ArrayBuffer(1,2,3,4,5)
  a.clear
  println(a)

  //修改Array
  //Array
  val a2 = Array("apple", "banana", "cherry")
  a2(0) = ""
  a2(1) = null
  println(a2.toList)


  val a3 = Array("apple", "banana", "cherry")  //a: Array[String] = Array(apple, banana, cherry)
  val b = a3.filter(! _.contains("a"))     //b: Array[String] = Array(cherry)

  println(b.toList)

  var a4 = Array("apple", "banana", "cherry")
  a4 = a4.take(2)
  println(a4.toList)

}
