package scalacookbook.chapter20

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liguodong on 2016/8/27.
  */
object PreferImmutableObjects extends App{

  //两个部分 不可变
  //不可变集合
  //use immutable sequences like List and Vector before reaching for the mutable ArrayBuffer.
  //不可变变量
  //That is, prefer val to var.


  //Although Scala treats method arguments as vals
  //the evilMutator method can call clear because the contents of an ArrayBuffer are mutable
  class Person
  def evilMutator(people: ArrayBuffer[Person]) {
    people.clear()
  }



  //To make your code safe from this problem,
  // if there’s no reason for a collection to be changed,
  // don’t use a mutable collection class
  def evilMutator(people: Vector[Person]) {
    // ERROR - won't compile
    //people.clear()
  }
  //Because Vector is immutable, any attempt to add or remove elements will fail.



  //Using val + mutable, and var + immutable



}
