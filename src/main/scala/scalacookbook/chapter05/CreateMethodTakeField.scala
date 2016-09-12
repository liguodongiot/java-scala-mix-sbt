package scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object CreateMethodTakeField extends App{

  def printAll(strings: String*) {
    strings.foreach(println)
  }

  // these all work
  printAll()
  println("~~~~~~~~~~~~~")
  printAll("foo")
  println("~~~~~~~~~~~~~")
  printAll("foo", "bar")
  println("~~~~~~~~~~~~~")
  printAll("foo", "bar", "baz")

  // a sequence of strings
  val fruits = List("apple", "banana", "cherry")

  //使用 _* 适应一个序列
  // use Scala’s _* operator to adapt a sequence (Array, List, Seq, Vector, etc.)

  // pass the sequence to the varargs field
  printAll(fruits: _*)

  //方法只有一个可变参数，可以使用无参数方式调用。
  //a method that has only one varargs field, you can call it with no arguments
  def printAll2(numbers: Int*) {
    numbers.foreach(println)
  }

  printAll2()


  def printAll3(numbers: Int*) {
    println(numbers.getClass)
  }

  printAll3(1, 2, 3)  //class scala.collection.mutable.WrappedArray$ofInt

  printAll3() //class scala.collection.immutable.Nil$


  //在方法内部使用循环处理可变参数
  //use a loop inside a method to handle a varargs field

//  // version 1
//  def printAll(numbers: Int*) {
//    numbers.foreach(println)
//  }
//  // version 2
//  def printAll(numbers: Int*) {
//    for (i <- numbers) println
//  }

}
