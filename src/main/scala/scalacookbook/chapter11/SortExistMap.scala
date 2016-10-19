package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object SortExistMap extends App {

  val grades = Map("Kim" -> 90,
    "Al" -> 85,
    "Melissa" -> 95,
    "Emily" -> 91,
    "Hannah" -> 92
  )

  println(grades)

  import scala.collection.immutable.ListMap
  //You can sort the map by key, from low to high, using sortBy
  val keySort = ListMap(grades.toSeq.sortBy(_._1):_*)
  println(keySort)

  // low to high
  val keyLowToHigh = ListMap(grades.toSeq.sortWith(_._1 < _._1):_*)
  println(keyLowToHigh)

  // high to low
  val keyHighToLow = ListMap(grades.toSeq.sortWith(_._1 > _._1):_*)
  println(keyHighToLow)

  //You can sort the map by value using sortBy.
  val valueSort = ListMap(grades.toSeq.sortBy(_._2):_*)
  println(valueSort)

  // low to high
  val valueLowToHigh = ListMap(grades.toSeq.sortWith(_._2 < _._2):_*)

  // high to low
  val valueHighToLow = ListMap(grades.toSeq.sortWith(_._2 > _._2):_*)

  //以上的这些例子，这个排序方法的结果将会分配一个新的排序map，

  //you can use either a ListMap or a LinkedHashMap in these recipes.

  //use a LinkedHashMap and assign the result to a new variable
  val x = collection.mutable.LinkedHashMap(grades.toSeq.sortBy(_._1):_*)

  x.foreach(println)

  //Discussion
  val grades2 = Map("Kim" -> 90,
    "Al" -> 85,
    "Melissa" -> 95,
    "Emily" -> 91,
    "Hannah" -> 92
  )

  println(grades2.toSeq)
  println(grades2.toSeq.sortBy(_._1))
  println(grades2.toSeq.sortWith(_._1 < _._1))
  println(ListMap(grades.toSeq.sortBy(_._1):_*))


  //The LinkedHashMap also retains the sort order of its elements,
  // so it can be used in all of the examples as well.
  import scala.collection.mutable.LinkedHashMap
  println(LinkedHashMap(grades.toSeq.sortBy(_._1):_*))


  //About that _*
  val x2 = grades.toSeq.sortBy(_._1)
  println(x)

  println(ListMap(x2: _*))

  //println(ListMap(x2))  //error

  def printAll(strings: String*) {
    strings.foreach(println)
  }

  //create a List
  // a sequence of strings
  val fruits = List("apple", "banana", "cherry")

  // printAll(fruits) //error

  // this works
  printAll(fruits: _*)


}
