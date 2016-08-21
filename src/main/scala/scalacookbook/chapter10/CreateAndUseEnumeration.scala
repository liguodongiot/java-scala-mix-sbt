package cb010

/**
  * Created by liguodong on 2016/7/30.
  */
object CreateAndUseEnumeration extends App{

  import com.acme.app.Margin._
  // use an enumeration value in a test
  var currentMargin = TOP

  // later in the code ...
  if (currentMargin == TOP) println("working on Top")

  // print all the enumeration values
  import com.acme.app.Margin
  Margin.values foreach println

  //Enumerations are useful tool for creating groups of constants,
  // such as days of the week,weeks of the year,
  // and many other situations where you have a group of related, constant values.


}


package com.acme.app {
  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }
}

// a much "heavier" approach
// most of which you won’t need
package com.acme.app2 {
  trait Margin
  case object TOP extends Margin
  case object RIGHT extends Margin
  case object BOTTOM extends Margin
  case object LEFT extends Margin
}