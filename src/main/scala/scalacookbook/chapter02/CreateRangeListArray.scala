package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/18.
 */
object CreateRangeListArray extends App{

  val r = 1 to 10
  println(r)

  val r2 = 1 to 10 by 2
  println(r2)

  val r3 = 1 to 10 by 3
  println(r3)

  for (i <- 1 to 5) print(i+" ")
  println

  for (i <- 1 until 5) print(i+" ")
  println

  val xArray = 1 to 10 toArray

  println(xArray)

  val xList = 1 to 10 toList

  val xList2 = (1 to 10).toList

  val xArray2 = (1 to 10).toArray

  var range = 0 to scala.util.Random.nextInt(10)

  for (i <- 1 to 5) yield println(i * 2 +" ")

  for (i <- 1 to 5) yield println(i.toDouble+" ")

  xList2.map(_*2+":").foreach(print)



}
