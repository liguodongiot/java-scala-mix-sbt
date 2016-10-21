package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object ChooseMapImpl extends App{

  //If you want a map that returns its elements in sorted order by keys, use a SortedMap.
  import scala.collection.SortedMap
  val grades = SortedMap("Kim" -> 90,
    "Al" -> 85,
    "Melissa" -> 95,
    "Emily" -> 91,
    "Hannah" -> 92
  )
  println(grades)

  //希望一个map中记住插入的元素的顺序
  //If you want a map that remembers the insertion order of its elements,
  // use a LinkedHashMap or ListMap.

  //Scala only has a mutable LinkedHashMap, and it returns its
  //elements in the order you inserted them

  //从后顺序插入
  import scala.collection.mutable.LinkedHashMap
  var states = LinkedHashMap("IL" -> "Illinois")
  states += ("KY" -> "Kentucky")
  states += ("TX" -> "Texas")
  println(states)

  states += ("AB" -> "Texas")
  println(states)

  //Scala has both mutable and immutable ListMap classes. They return elements in the
  //opposite order in which you inserted them, as though each insert was at the head of the
  //map (like a List)

  //从前顺序插入
  import scala.collection.mutable.ListMap
  var states2 = ListMap("IL" -> "Illinois")

  states2 += ("KY" -> "Kentucky")
  println(states2)

  states2 += ("TX" -> "Texas")
  println(states2)

  states2 += ("AB" -> "Texas")
  println(states2)


  //The LinkedHashMap implements a mutable map using a hashtable,
  // whereas a ListMap is backed by a list-based data structure.
  // (Personally, I don’t use the List class very often, so I prefer the LinkedHashMap.)

}
