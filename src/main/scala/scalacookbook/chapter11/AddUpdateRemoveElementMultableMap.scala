package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object AddUpdateRemoveElementMultableMap extends App{

  var states = scala.collection.mutable.Map[String, String]()
  //增加一个元素
  states("AK") = "Alaska"
  states += ("AL" -> "Alabama")

  //增加多个元素
  states += ("AR" -> "Arkansas", "AZ" -> "Arizona")

  //从另一个集合增加多个元素
  states ++= List("CA" -> "California", "CO" -> "Colorado")

  println(states)

  //移除一个元素
  states -= "AR"

  //移除多个元素
  states -= ("AL", "AZ")

  // remove multiple with a List of keys
  states --= List("AL", "AZ")

  println(states)

  //更新
  states("AK") = "Alaska, A Really Big State"

  println(states)

  println("-----------------")

  //导包不推荐使用相对路径  建议scala.collection.mutable.Map
  //Discussion
  val states2 = collection.mutable.Map(
    "AK" -> "Alaska",
    "IL" -> "Illinois",
    "KY" -> "Kentucky"
  )
  states2.put("CO", "Colorado")
  println(states2)

  //删除元素

  states2.retain((k,v) => k == "AK")
  println(states2)

  states2.remove("AK")
  println(states2)  //scala.collection.mutable.Map[String,String] = Map()

  states2 ++= List("CA" -> "California", "CO" -> "Colorado")
  println(states2)

  states2.clear
  println(states2)


  //Scala also offers several more map types that have parallel/concurrent implementations built into them:
  //  • collection.parallel.immutable.ParHashMap
  //  • collection.parallel.mutable.ParHashMap
  //  • collection.concurrent.TrieMap


}
