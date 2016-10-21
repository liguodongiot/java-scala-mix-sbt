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

  //As shown in these examples, keysIterator and valuesIterator return an iterator
  //from the map data. I tend to prefer these methods because they don’t create a new
  //collection; they just provide an iterator to walk over the existing elements.
  println(states.keysIterator.toList)
  println(states.valuesIterator.toList)

  val tempIterator = states.valuesIterator

  for( temp <- tempIterator) println(temp)
  println("----------")
  for( temp <- tempIterator) println(temp)
  println("----------")
}
