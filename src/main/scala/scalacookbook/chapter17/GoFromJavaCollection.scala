package scalacookbook.chapter17

/**
  * Created by liguodong on 2016/8/19.
  */
object GoFromJavaCollection extends App{

  val list = nums

  //by importing the methods from the JavaConversions object,
  // the ArrayList magically acquires a foreach method
  import scala.collection.JavaConversions._
  list.foreach(println)



  def nums = {
     var list = new java.util.ArrayList[Int]()
     list.add(1)
     list.add(2)
     list
  }

  //Discussion
  println("========Discussion========")
  //import the JavaConversions.asScalaBuffer method.
  // When you do this, you can either explicitly call the asScalaBuffer method,
  // or let it be used implicitly.
  /*显示调用*/
  import scala.collection.JavaConversions.asScalaBuffer
  val numbers = asScalaBuffer(JavaExamples.getNumbers)
  numbers.foreach(println)
  // prints 'scala.collection.convert.Wrappers$JListWrapper'
  println(numbers.getClass)


  /*隐式转换*/
  import scala.collection.JavaConversions.asScalaBuffer
  val numbers2 = JavaExamples.getNumbers
  numbers2.foreach(println)
  // prints 'java.util.ArrayList'
  println(numbers2.getClass)

  println("========Map==========")
  import scala.collection.JavaConversions.mapAsScalaMap
  // explicit call
  val peeps1 = mapAsScalaMap(JavaExamples.getPeeps)
  peeps1.foreach(println)

  // implicit conversion
  val peeps2 = JavaExamples.getPeeps
  peeps2.foreach(println)


  //Going from Scala collections to Java collections

  import scala.collection.JavaConversions._
  import scala.collection.mutable._
  val sum1 = ConversionExamples.sum(seqAsJavaList(Seq(1, 2, 3)))
  val sum2 = ConversionExamples.sum(bufferAsJavaList(ArrayBuffer(1,2,3)))
  val sum3 = ConversionExamples.sum(bufferAsJavaList(ListBuffer(1,2,3)))

  println("sum1:["+sum1+"],sum2:["+sum2+"],sum3:["+sum3+"]")

}
