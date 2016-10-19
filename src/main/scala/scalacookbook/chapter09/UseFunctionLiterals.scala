package scalacookbook.chapter09

import com.typesafe.scalalogging.slf4j.Logger
import org.slf4j.LoggerFactory

/**
  * Created by liguodong on 2016/7/23.
  */

object UseFunctionLiterals extends App{

  val LOGGER = Logger(LoggerFactory.getLogger(UseFunctionLiterals.getClass))


  val x = List.range(1, 10)
  val evens = x.filter((i: Int) => i % 2 == 0)

  println(evens)

  val evens2 = x.filter(i => i % 2 == 0)
  println(evens2)

  val evens3 = x.filter(_ % 2 == 0)
  println(evens3)

  println("~~~~~~~~~~~~~~~~")

  x.foreach((i) => println(i))
  x.foreach(i => println(i))
  x.foreach(println(_))
  x.foreach(println)

  println(x.size+" "+x.length)
  LOGGER.info("x is:[{}]",x)

  val arg = Array("The", "brown", "fox", "jumps", 42)
  LOGGER.info("five parameters: {}, {}, {}, {}, {}", "The", "brown", "fox", "jumps", "32")
}
