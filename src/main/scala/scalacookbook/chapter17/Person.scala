package scalacookbook.chapter17

import scala.beans.BeanProperty

/**
  * You need to interact with a Java class or library that accepts
  * only classes that conform to the JavaBean specification.
  *
  * Created by liguodong on 2016/8/19.
  */

//Use the @BeanProperty annotation on your fields,
// also making sure you declare each field as a var.
class Person(@BeanProperty var firstName: String,
             @BeanProperty var lastName: String) {
  override def toString = s"Person: $firstName $lastName"
}

class EmailAccount {
  @BeanProperty var username: String = ""
  @BeanProperty var password: String = ""
  override def toString = s"Email Account: ($username, $password)"
}