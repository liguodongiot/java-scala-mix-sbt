package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object TransformOneCollectionAnotherMap  extends App{

  val helpers = Vector("adam", "kim", "melissa")

  // the long form
  val caps = helpers.map(e => e.capitalize)
  println(caps)

  // the short form
  val caps2 = helpers.map(_.capitalize)

  println("---------------")

  val names = Array("Fred", "Joe", "Jonathan")
  val lengths = names.map(_.length)

  println(lengths.toSeq)

  val nieces = List("Aleka", "Christina", "Molly")

  // convert a collection to a list of XML elements
  val elems = nieces.map(niece => <li>{niece}</li>)
  println(elems)

  // convert the collection directly to an XML literal(文本)
  val ul = <ul>{nieces.map(i => <li>{i}</li>)}</ul>
  println(ul)

  // imagine this is a long method
  def plusOne(c: Char): Char = (c.toByte+1).toChar

  val plus = "HAL".map(plusOne)
  plus.foreach(println)


  val s = " eggs, milk, butter, Coco Puffs "
  val items = s.split(",").map(_.trim)
  println(items.toVector)

  //Discussion
  val people = List("adam", "kim", "melissa")

  // map
  val caps3 = people.map(_.capitalize)
  println(caps3)

  // for/yield
  val caps4 = for (f <- people) yield f.capitalize
  println(caps4)

  println("---------------")

  val fruits = List("apple", "banana", "lime", "orange", "raspberry")
  val newFruits = fruits.map( f =>
    if (f.length < 6) f.toUpperCase
  )
  println(newFruits)

  val filterFruit = newFruits.filter(_ != ())
  println(filterFruit)

  val resultFruit =  fruits.filter(_.length < 6).map(_.toUpperCase).filter( _ != ())
  println(resultFruit)

}
