package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/7.
 */
object AccessCharFromString {

  def main(args: Array[String]) {

    println("hello".charAt(0))
    println("hello"(0))
    println("hello"(1))
    println("hello".apply(1))


  }
}
