package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object DeleteElementList extends App{

  val originalList = List(5, 1, 4, 3, 2)
  //List是不可变的，因此想要删除元素，需要过滤掉出想要的结果到一个新的变量。
  val newList = originalList.filter(_ > 2) //List(5, 4, 3)

  println(newList)

  //ListBuffer

  import scala.collection.mutable.ListBuffer
  val x = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)

  x -= 5 //x.type = ListBuffer(1, 2, 3, 4, 6, 7, 8, 9)

  x -= (2, 3) //x.type = ListBuffer(1, 4, 6, 7, 8, 9)

  x.remove(0) //ListBuffer(4, 6, 7, 8, 9)
  println(x)

  x.remove(1, 3)  //ListBuffer(4, 9)
  println(x)

  val y = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)

  // use --= to delete multiple elements that are specified in another collection
  y --= Seq(1,2,3)

  println(y)

}
