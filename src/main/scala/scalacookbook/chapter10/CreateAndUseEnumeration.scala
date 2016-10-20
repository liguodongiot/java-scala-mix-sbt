package cb010

/**
  * Created by liguodong on 2016/7/30.
  */
object CreateAndUseEnumeration extends App{

  import cb010.com.acme.app.Margin._

  // use an enumeration value in a test
  var currentMargin = TOP

  // later in the code ...
  if (currentMargin == TOP) println("working on Top")

  // print all the enumeration values
  import cb010.com.acme.app.Margin
  Margin.values foreach println

  //Enumerations are useful tool for creating groups of constants,
  // such as days of the week,weeks of the year,
  // and many other situations where you have a group of related, constant values.

  import cb010.com.acme.app2._

  val temp = TOP2
  if (temp == TOP2) println("working on Top2")


}


package com.acme.app {
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }
}

//不推荐
//You can also use the following approach, but it generates about four times as much code
//as an Enumeration, most of which you won’t need if your sole purpose is to use it like
//an enumeration:
package com.acme.app2 {
  trait Margin2
  case object TOP2 extends Margin2
  case object RIGHT2 extends Margin2
  case object BOTTOM2 extends Margin2
  case object LEFT2 extends Margin2
}