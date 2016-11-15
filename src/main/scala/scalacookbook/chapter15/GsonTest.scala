package scalacookbook.chapter15

import com.google.gson.Gson

/**
  * Created by liguodong on 2016/8/17.
  */


object GsonTest extends App {
  case class Person(name: String, address: Address)
  case class Address(city: String, state: String)


  val p = Person("Alvin Alexander", Address("Talkeetna", "AK"))
  // create a JSON string from the Person, then print it
  val gson = new Gson
  val jsonString = gson.toJson(p)
  println(jsonString)
}