package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */
object SetUninitializedField extends App{

  case class Person(var username: String, var password: String) {
    var age = 0
    var firstName = ""
    var lastName = ""
    var address = None: Option[Address]
  }

  case class Address(city: String, state: String, zip: String)



  val p = Person("alvinalexander", "secret")

  p.address = Some(Address("Talkeetna", "AK", "99676"))

  p.address.foreach { a =>
    println(a.city)
    println(a.state)
    println(a.zip)
  }


  //Discussion
  var i = 0 // Int
  var d = 0.0 // Double

  var b: Byte = 0
  var c: Char = 0
  var f: Float = 0
  var l: Long = 0
  var s: Short = 0



}

