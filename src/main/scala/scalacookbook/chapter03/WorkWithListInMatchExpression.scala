package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */
object WorkWithListInMatchExpression extends App{

  //create a List
  val x = List(1, 2, 3)

  val y = 1 :: 2 :: 3 :: Nil

  //递归
  def listToString(list: List[String]): String = list match {
    case s :: rest => s + " " + listToString(rest)
    case Nil => ""
  }

  val fruits = "Apples" :: "Bananas" :: "Oranges" :: Nil
  listToString(fruits)


  def sum(list: List[Int]): Int = list match {
    case Nil => 1
    case n :: rest => n + sum(rest)
  }
  def multiply(list: List[Int]): Int = list match {
    case Nil => 1
    case n :: rest => n * multiply(rest)
  }

  val nums = List(1,2,3,4,5)

  println(sum(nums))

  println(multiply(nums))

}
