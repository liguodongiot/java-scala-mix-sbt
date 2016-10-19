package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object UnderstandPerformanceCollections extends App{

  //追加操作在 Vector 是有效的常数时间。
  var v = Vector[Int]()
  for (i <- 1 to 50000) v = v :+ i

  //而List进行追加操作是线性时间，因此，进行相同的操作需要非常多的时间。


}
