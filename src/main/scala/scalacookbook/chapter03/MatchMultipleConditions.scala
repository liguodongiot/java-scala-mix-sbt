package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */
object MatchMultipleConditions extends App{

  val i = 5
  i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }

  //println(i)

  val cmd = "stop"
  cmd match {
    case "start" | "go" => println("starting")
    case "stop" | "quit" | "exit" => println("stopping")
    case _ => println("doing nothing")
  }
  //println(cmd)

}
