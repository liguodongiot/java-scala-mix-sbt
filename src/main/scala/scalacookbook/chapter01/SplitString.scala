package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/6.
 */
object SplitString {
  def main(args: Array[String]) {
    "hello world".split(" ").foreach(println)

    val s = "eggs, milk, butter, Coco Puffs"
    s.split(",").foreach(print)
    println

    s.split(",").map(_.trim).foreach(print)
    println

    "hello world, this is Al".split("\\s+").foreach(print)
    println

    // split with a String argument
    println("hello world".split(" "))

    // split with a Char argument
    println("hello world".split(' '))
  }
}
