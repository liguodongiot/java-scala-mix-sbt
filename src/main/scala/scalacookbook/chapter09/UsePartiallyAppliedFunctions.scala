package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/24.
  */
object UsePartiallyAppliedFunctions extends App{

  val sum = (a: Int, b: Int, c: Int) => a + b + c //sum: (Int, Int, Int) => Int = <function3>

  val f = sum(1, 2, _: Int) //f: Int => Int = <function1>

  println(f(3))

  def wrap(prefix: String, html: String, suffix: String) = {
    prefix + html + suffix
  }

  val wrapWithDiv = wrap("<div>", _: String, "</div>")
  println(wrapWithDiv("<p>Hello, world</p>"))

  println(wrapWithDiv("<img src=\"/images/foo.png\" />"))

  println("~~~~~~~~~~~~~~~~~~~~")

  //you can still call the original wrap function if you want.
  println(wrap("<pre>", "val x = 1", "</pre>"))
}
