package scalacookbook.chapter02

//import com.github.nscala_time.time.StaticDateTime

/**
 * Created by liguodong on 2016/6/7.
 */


//In Scala, all the numeric types are objects, including Byte,
// Char, Double, Float, Int, Long, and Short.
object Main {
  def main(args: Array[String]) {

    println(Short.MinValue)
    println(Short.MaxValue)

    println(Int.MinValue)
    println(Float.MinValue)

    println("===~~~===~~~===")
//    import com.github.nscala_time.time.Imports._
//
//
//    println(DateTime.now) // returns org.joda.time.DateTime
//    println(2.months)
//
//    //DateTime.nextMonth < DateTime.now + 2.day
//    println((2.hours + 45.minutes + 10.seconds).millis)


  }
}

/*
  <dependency>
    <groupId>com.github.nscala-time</groupId>
    <artifactId>nscala-time_2.10</artifactId>
    <version>2.0.0</version>
  </dependency>
*/
