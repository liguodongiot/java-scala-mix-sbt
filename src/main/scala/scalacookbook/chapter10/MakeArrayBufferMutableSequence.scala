package scalacookbook.chapter10

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liguodong on 2016/7/24.
  */
object MakeArrayBufferMutableSequence extends App{

  //create an empty ArrayBuffer
  var fruits = ArrayBuffer[String]()
  var ints = ArrayBuffer[Int]()

  //create an ArrayBuffer with initial elements
  var nums = ArrayBuffer(1, 2, 3)

  // add one element
  nums += 4

  // add two or more elements (method has a varargs parameter)
  nums += (5, 6)

  // add elements from another collection
  nums ++= List(7, 8)


  // remove one element
  nums -= 9

  // remove two or more elements
  nums -= (7, 8)

  // remove elements specified by another sequence
  nums --= Array(5, 6)

  //Discussion
  val a = ArrayBuffer(1, 2, 3) // ArrayBuffer(1, 2, 3)
  a.append(4) // ArrayBuffer(1, 2, 3, 4)
  a.append(5, 6) // ArrayBuffer(1, 2, 3, 4, 5, 6)
  a.appendAll(Seq(7,8)) // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8)
  a.clear // ArrayBuffer()

  val a2 = ArrayBuffer(9, 10) // ArrayBuffer(9, 10)
  a2.insert(0, 8) // ArrayBuffer(8, 9, 10)
  a2.insert(0, 6, 7) // ArrayBuffer(6, 7, 8, 9, 10)
  a2.insertAll(0, Vector(4, 5)) // ArrayBuffer(4, 5, 6, 7, 8, 9, 10)
  a2.prepend(3) // ArrayBuffer(3, 4, 5, 6, 7, 8, 9, 10)
  a2.prepend(1, 2) // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  a2.prependAll(Array(0)) // ArrayBuffer(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val a3 = ArrayBuffer.range('a', 'h') // ArrayBuffer(a, b, c, d, e, f, g)
  a3.remove(0) // ArrayBuffer(b, c, d, e, f, g)
  a3.remove(2, 3) // ArrayBuffer(b, c, g)

  val a4 = ArrayBuffer.range('a', 'h') // ArrayBuffer(a, b, c, d, e, f, g)
  a4.trimStart(2) // ArrayBuffer(c, d, e, f, g)
  a4.trimEnd(2) // ArrayBuffer(c, d, e)


}
