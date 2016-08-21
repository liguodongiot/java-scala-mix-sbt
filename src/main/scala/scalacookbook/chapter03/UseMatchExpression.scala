package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */
object UseMatchExpression extends App{

  var i=111

  // i is an integer
  val ret = i match {
    case 1 => println("January")
    case 2 => println("February")
    case 3 => println("March")
    case 4 => println("April")
    case 5 => println("May")
    case 6 => println("June")
    case 7 => println("July")
    case 8 => println("August")
    case 9 => println("September")
    case 10 => println("October")
    case 11 => println("November")
    case 12 => println("December")
    // catch the default with a variable so you can print it
    case whoa => println("Unexpected case: " + whoa.toString)
  }

  println(ret)

  val month = i match {
    case 1 => "January"
    case 2 => "February"
    case 3 => "March"
    case 4 => "April"
    case 5 => "May"
    case 6 => "June"
    case 7 => "July"
    case 8 => "August"
    case 9 => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _ => "Invalid month" // the default, catch-all
  }

  println(month)

  //The @switch annotation
  val switchDemo = new SwitchDemo
  println(switchDemo.x)

  val switchDemo2 = new SwitchDemo2
  println(switchDemo2.x)

  def getClassAsString(x: Any): String = x match {
    case s: String => s + " is a String"
    case i: Int => "Int"
    case f: Float => "Float"
    case l: List[_] => "List"
    case p: Person => "Person"
    case _ => "Unknown"
  }

  println("getClassAsString:"+getClassAsString(1000))

  //Handling the default case
  //case _ => println("Got a default match")
  //case default => println(default)
  //case oops => println(oops)


  //You can generate a MatchError if you don’t handle the default case
  i=0
  i match {
    case 0 => println("0 received")
    case 1 => println("1 is good, too")
  }


  val monthNumberToName = Map(
    1 -> "January",
    2 -> "February",
    3 -> "March",
    4 -> "April",
    5 -> "May",
    6 -> "June",
    7 -> "July",
    8 -> "August",
    9 -> "September",
    10 -> "October",
    11 -> "November",
    12 -> "December"
  )
  val monthName = monthNumberToName(4)
  println(monthName) // prints "April"


}

import scala.annotation.switch
// Version 1 - compiles to a tableswitch
class SwitchDemo {
  val i = 1
  val x = (i: @switch) match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Other"
  }
}

// Version 2 - leads to a compiler warning
class SwitchDemo2 {
  val i = 1
  val Two = 2 // added
  val x = (i: @switch) match {
      case 1 => "One"
      case Two => "Two" // replaced the '2'
      case _ => "Other"
    }
}