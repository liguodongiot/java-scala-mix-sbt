package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object CreateMutableList extends App{

  import scala.collection.mutable.ListBuffer
  var fruits = new ListBuffer[String]()
  // add one element at a time to the ListBuffer
  fruits += "Apple"
  fruits += "Banana"
  fruits += "Orange"

  // add multiple elements
  fruits += ("Strawberry", "Kiwi", "Pineapple")
  // remove one element
  fruits -= "Apple"
  // remove multiple elements
  fruits -= ("Banana", "Orange")
  // remove multiple elements specified by another sequence
  fruits --= Seq("Kiwi", "Pineapple")
  // convert the ListBuffer to a List when you need to
  val fruitsList = fruits.toList


  //a List is immutable, if you need to create a list that is constantly changing,
  //the preferred approach is to use a ListBuffer while the list is being modified.
  val x = List(2) //x: List[Int] = List(2)
  val y = 1 :: x  //y: List[Int] = List(1, 2)
  val z = 0 :: y  //z: List[Int] = List(0, 1, 2)





}
