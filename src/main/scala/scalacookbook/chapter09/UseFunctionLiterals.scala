package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object UseFunctionLiterals extends App{

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



}
