package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object CreateMap extends App{

  //To use an immutable map, you don’t need an import statement, just create a Map.
  val states = Map("AL" -> "Alabama", "AK" -> "Alaska")

  println(states)

  //type Map[A, +B] = immutable.Map[A, B]
  //val Map = immutable.Map

  println("------------------")

  //可变的map
  var states2 = collection.mutable.Map("AL" -> "Alabama")
  println(states2)

  var states3 = collection.mutable.Map[String, String]()  //scala.collection.mutable.Map[String,String] = Map()
  states3 += ("AL" -> "Alabama")  //scala.collection.mutable.Map[String,String] = Map(AL -> Alabama)

  println(states3)

  println("~~~~~~~~~~~~~~~~~~~~~")

  //Discussion
  val states4 = Map( ("AL", "Alabama"), ("AK", "Alaska") )
  //scala.collection.immutable.Map[String,String] = Map(AL -> Alabama, AK -> Alaska)
  println(states4)

  //重命名
  import scala.collection.mutable.{Map => MMap}
  // MMap is really scala.collection.mutable.Map
  val m = MMap(1 -> 'a')
  for((k,v) <- m) println(s"$k, $v")

}
