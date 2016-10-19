package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/30.
  */
object CreateLazyViewOnCollection extends App{

  println(1 to 5)

  println((1 to 5).view)

  val view = (1 to 5).view
  println(view)

  val x = view.force
  println(x)

  println("----------------")

  //using a method like foreach doesn’t seem to change when using a view
  (1 to 5).foreach(println)
  println("----------------")
  (1 to 5).view.foreach(println)
  println("----------------")

  //calling a map method with and without a view
  //has dramatically different results
  println((1 to 5).map { _ * 2 })

  println((1 to 5).view.map { _ * 2 })

  println("----------------")

  //If you run that code as shown, it will return immediately,
  // returning a SeqView as before.
  //But if you remove the view method call,
  // the code block will take about 5 seconds to run.
  val x2 = (1 to 5).view.map { e =>
    Thread.sleep(1000)
    e * 2
  }
  println(x2)

  val x3 = (1 to 5).map { e =>
    Thread.sleep(1000)
    e * 2
  }
  println(x3)

  //Discussion
  val l = List(1,2,3)
  println(l.reverse)

  println(l.view.reverse)

  val x4 = (1 to 5).view.map { e =>
    Thread.sleep(10)
    e * 2
  }

  x4.foreach(print)

  //Use cases
  // create a normal array
  val arr = (1 to 10).toArray

  // create a view on the array
  val view2 = arr.view.slice(2, 5)

  // modify the array
  arr(2) = 42
  println(view2)

  //修改原数组，视图也会受到影响。
  // the view is affected:
  view2.foreach(println)

  // change the elements in the view
  view2(0) = 10
  view2(1) = 20
  view2(2) = 30

  // the array is affected:
  arr


  //不要混乱使用视图保存在内存中，有可能会造成OutOfMemoryError
  //eg:
  //val aa = Array.range(0,123456789)
  //val aa2 = Array.range(0,123456789).view
}
