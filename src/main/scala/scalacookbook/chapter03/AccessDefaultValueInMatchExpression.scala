package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */
object AccessDefaultValueInMatchExpression extends App{

  val i=102
  i match {
    case 0 => println("1")
    case 1 => println("2")
    case default => println("You gave me: " + default)
  }

  i match {
    case 0 => println("1")
    case 1 => println("2")
    case whoa => println("You gave me: " + whoa)
  }


  //It’s important to provide a default match.
  // Failure to do so can cause a MatchError:
  /*
  3 match {
    case 1 => println("one")
    case 2 => println("two")
    // no default match
  }
  */

}
