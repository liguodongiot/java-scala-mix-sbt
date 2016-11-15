package scalacookbook.chapter15

import net.liftweb.json.Serialization.write
import net.liftweb.json._

/**
  * Created by liguodong on 2016/8/16.
  */



//use the best libraries that are available for Scala and Java.
/*
• Lift-JSON
• The Google Gson library (Java)
• Json4s
• spray-json
*/

object LiftJsonTest extends App {
  case class Person(name: String, address: Address)
  case class Address(city: String, state: String)

  val p = Person("Alvin Alexander", Address("Talkeetna", "AK"))

  // create a JSON string from the Person, then print it
  implicit val formats = DefaultFormats

  val jsonString = write(p)
  println(jsonString)
}