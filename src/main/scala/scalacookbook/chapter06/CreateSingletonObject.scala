package scalacookbook.chapter06

import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Created by liguodong on 2016/7/9.
 */
object CreateSingletonObject extends App{

  CashRegister.open
  CashRegister.close

  //This pattern is also common when creating utility methods, such as this DateUtils object.

  DateUtils.getCurrentTime
  DateUtils.getCurrentDate

  //If you have a
  //number of actors that can all receive start and stop messages, you can create Singletons
//  case object StartMessage
//  case object StopMessage

  //use those objects as messages that can be sent to actors
//  inputValve ! StopMessage
//  outputValve ! StopMessage

}

object CashRegister {
  def open { println("opened") }
  def close { println("closed") }
}


object DateUtils {
  // as "Thursday, November 29"
  def getCurrentDate: String = getCurrentDateTime("EEEE, MMMM d")

  // as "6:20 p.m."
  def getCurrentTime: String = getCurrentDateTime("K:m aa")

  // a common function used by other date/time functions
  private def getCurrentDateTime(dateTimeFormat: String): String = {
    val dateFormat = new SimpleDateFormat(dateTimeFormat)
    val cal = Calendar.getInstance()
    dateFormat.format(cal.getTime())
  }
}