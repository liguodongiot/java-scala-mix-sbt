package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object CombineMapFlatten extends App{

  val bag = List("1", "2", "three", "4", "one hundred seventy five")
  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: Exception => None
    }
  }

  println("Sum:"+bag.flatMap(toInt).sum)

  //Discussion
  println(bag.map(toInt))

  println(bag.map(toInt).flatten)

  println(bag.map(toInt).flatten.sum)

  println(bag.flatMap(toInt).sum)

  println(bag.flatMap(toInt).filter(_ > 1))

  println(bag.flatMap(toInt).takeWhile(_ < 4))

  println(bag.flatMap(toInt).partition(_ > 3))

  def subWords(word: String) = List(word, word.tail, word.take(word.length-1))

  println(subWords("then"))

  val words = List("band", "start", "then")
  println(words.map(subWords))

  println(words.map(subWords).flatten)

  println(words.flatMap(subWords))


}
