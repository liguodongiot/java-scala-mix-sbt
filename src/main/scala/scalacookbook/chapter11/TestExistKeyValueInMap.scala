package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object TestExistKeyValueInMap extends App{

  val states = Map(
    "AK" -> "Alaska",
    "IL" -> "Illinois",
    "KY" -> "Kentucky"
  )

  if (states.contains("FOO")) println("Found foo") else println("No foo")

  //because at least one element in the collection
  //contains the String literal ucky, the exists call returns true
  println(states.valuesIterator.exists(_.contains("ucky")))

  println(states.valuesIterator.exists(_.contains("yucky")))

  println(states.valuesIterator)
  println(states.valuesIterator.toList)

}
