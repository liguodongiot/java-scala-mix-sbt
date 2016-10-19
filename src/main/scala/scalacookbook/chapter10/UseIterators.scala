package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/10/19.
  */
object UseIterators extends App{

  val it = Iterator(1,2,3)
  it.foreach(println)

  //But when you attempt the same call a second time,
  // you won’t get any output, because the iterator has been exhausted.
  it.foreach(println)

  println("~~~~~~~~~~~~~~~~")
  val it2 = Iterator(1,2,3)
  println(it2.toArray.mkString(","))

  //it.to[Tab]
  /*
  toArray toBuffer toIndexedSeq toIterable toIterator
  toList toMap toSeq toSet toStream
  toString toTraversable
  */

}
