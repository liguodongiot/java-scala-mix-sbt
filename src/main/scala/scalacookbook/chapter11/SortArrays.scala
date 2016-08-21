package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object SortArrays extends App{

  val fruits = Array("cherry", "apple", "banana")

  scala.util.Sorting.quickSort(fruits)
  println(fruits.toList)

}
