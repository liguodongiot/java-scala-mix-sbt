package scalacookbook.chapter09

import com.typesafe.scalalogging.slf4j.Logger
import org.slf4j.LoggerFactory

/**
  * Created by liguodong on 2016/7/23.
  */
object Main extends App{

  val logger = Logger(LoggerFactory.getLogger(Main.getClass))

  logger.info("This is very convenient...")

  val a=0
  val b=11
  val greater = if (a > b) a else b



  val aString = "213"

  val result = try {
    aString.toInt
  } catch {
    case _ => 0
  }


}
