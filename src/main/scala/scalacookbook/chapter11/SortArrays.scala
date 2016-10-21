package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object SortArrays extends App{

  val fruits = Array("cherry", "apple", "banana","dubbo","ear","spark","kafka")

  import scala.util.Sorting
  Sorting.quickSort(fruits)
  //Notice that quickSort sorts the Array in place;
  // there’s no need to assign the result to a new variable.

  println(fruits.toList)

  //Sorting.quickSort can also sort arrays with the base numeric types like Double,
  //Float, and Int, because they also have an implicit Ordering.

  //If the type an Array is holding doesn’t have an implicit Ordering, you can either modify
  //it to mix in the Ordered trait (which gives it an implicit Ordering), or sort it using the
  //sorted, sortWith, or sortBy methods.

}
