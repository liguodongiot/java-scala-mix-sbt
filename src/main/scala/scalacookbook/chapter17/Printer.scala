package scalacookbook.chapter17

import scala.annotation.varargs

/**
  * Created by liguodong on 2016/8/19.
  */
class Printer {

  //When a Scala method has a field that takes a variable number of arguments,
  // mark it with the @varargs annotation.

  @varargs def printAll(args: String*) {
    args.foreach(print)
    println
  }

  //Without the @varargs annotation, from a Java perspective, the printAll method ap‐
  //pears to take a scala.collection.Seq<java.lang.String> as its argument.
  //没有@varargs注解，将会调用失败。

}
