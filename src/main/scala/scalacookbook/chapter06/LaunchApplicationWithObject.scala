package scalacookbook.chapter06

/**
 * Created by liguodong on 2016/7/9.
 */
object LaunchApplicationWithObject extends App{

  if (args.length == 1)
    println(s"Hello, ${args(0)}")
  else
    println("I didn't get your name.")
}
