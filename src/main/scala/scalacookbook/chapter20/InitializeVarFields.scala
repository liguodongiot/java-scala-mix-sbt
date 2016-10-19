package scalacookbook.chapter20

/**
  * Created by liguodong on 2016/8/27.
  */
object InitializeVarFields extends App{

  case class Address (city: String, state: String, zip: String)
  class User(email: String, password: String) {
    var firstName: String = _
    var lastName: String = _
    var address: Address = _
  }
  //This is bad news(坏消息), because firstName, lastName,
  // and address are all declared to be null,
  // and can cause problems in your application if they’re not assigned
  // before they’re accessed.


  //A better approach is to define each field as an Option
  case class Address2 (city: String, state: String, zip: String)
  class User2(email: String, password: String) {
    var firstName = None: Option[String]
    var lastName = None: Option[String]
    var address = None: Option[Address]
  }


  val u = new User2("al@example.com", "secret")
  u.firstName = Some("Al")
  u.lastName = Some("Alexander")
  u.address = Some(Address("Talkeetna", "AK", "99676"))

  println(u.firstName.getOrElse("<not assigned>"))
  u.address.foreach { a =>
    println(a.city)
    println(a.state)
    println(a.zip)
  }

  //On a related note, you should also use an Option in a constructor when a field is optional:
  case class Stock (id: Long,
                    var symbol: String,
                    var company: Option[String])


}
