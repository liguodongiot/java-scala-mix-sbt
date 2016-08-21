package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object TransformOneCollectionAnotherMap  extends App{

  val helpers = Vector("adam", "kim", "melissa")

  // the long form
  val caps = helpers.map(e => e.capitalize)

  // the short form
  val caps2 = helpers.map(_.capitalize)

  val names = Array("Fred", "Joe", "Jonathan")
  val lengths = names.map(_.length)

  val nieces = List("Aleka", "Christina", "Molly")

  //val elems = nieces.map(niece => <li>{niece}</li>)

 // val ul = <ul>{nieces.map(i => <li>{i}</li>)}</ul>

  // imagine this is a long method
  def plusOne(c: Char): Char = (c.toByte+1).toChar

  "HAL".map(plusOne)

  val s = " eggs, milk, butter, Coco Puffs "
  val items = s.split(",").map(_.trim)

  //Discussion
  val people = List("adam", "kim", "melissa")

  // map
  val caps3 = people.map(_.capitalize)


  // for/yield
  val caps4 = for (f <- people) yield f.capitalize

  val fruits = List("apple", "banana", "lime", "orange", "raspberry")
  val newFruits = fruits.map( f =>
    if (f.length < 6) f.toUpperCase
  )

  newFruits.filter(_ != ())

  fruits.filter(_.length < 6).map(_.toUpperCase)

}
