package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/30.
  */
object PopulatingCollectionWithRange extends App{

  //the range method is available on the companion object of
  // supported types like Array, List, Vector, ArrayBuffer, and others.

  println(Array.range(1, 5).toList)
  println(List.range(0, 10))
  println(Vector.range(0, 10, 2))

  val a = (0 until 10).toArray
  println(a.toList)

  val list = 1 to 10 by 2 toList ;//注：这里必须要有分号表示结束，不然下面一行的打印操作会报错。
  println(list)

  val list2 = (1 to 10).by(2).toList
  println(list2)

  println("-----------------------")

  //shows the collections that can be created directly from a Range
  // toArray toBuffer toIndexedSeq toIterable toIterator toList toMap
  // toSeq toSet toStream toString toTraversable

  //Set不支持 range 方式填充数据
  //like Set, which don’t offer a range method
  // intentional error
  //val set = Set.range(0, 5)

  val set2 = (0 until 10 by 2).toSet
  println(set2)

  val letters = ('a' to 'f').toList // List(a, b, c, d, e, f)
  println(letters)

  val letters2 = ('a' to 'f').by(2).toList
  println(letters2)

  println("------------------------")

  for (i <- 1 until 10 by 2) println(i)

  //Discussion
  val map = (1 to 5).map(_ * 2.0) //Vector(2.0, 4.0, 6.0, 8.0, 10.0)
  println(map)

  val map2 = (1 to 5).map(e => (e,e)) //Vector((1,1), (2,2), (3,3), (4,4), (5,5))
  println(map2)

  val map3 = (1 to 5).map(e => (e,e)).toMap //Map(5 -> 5, 1 -> 1, 2 -> 2, 3 -> 3, 4 -> 4)
  println(map3)


}
