package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object GetKeyValueFromMap extends App{


  val states = Map("AK" -> "Alaska", "AL" -> "Alabama", "AR" -> "Arkansas")

  println(states)

  //To get the keys,
  // use keySet to get the keys as a Set,
  // keys to get an Iterable,
  // or keysIterator to get the keys as an iterator.
  println(states.keySet)

  println(states.keys)

  println(states.keysIterator)

  //To get the values from a map,
  // use the values method to get the values as an Iterable,
  //or valuesIterator to get them as an Iterator.

  println(states.values)  //Iterable[String] = MapLike(Alaska, Alabama, Arkansas)

  println(states.valuesIterator)


}
