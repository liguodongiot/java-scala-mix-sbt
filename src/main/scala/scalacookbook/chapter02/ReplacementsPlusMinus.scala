package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/12.
 */
object ReplacementsPlusMinus extends App{

  var a = 1
  a += 1
  println(a)

  a -= 1
  println(a)

  var i = 1
  i *= 2

  i /= 2
  println(i)


  var x1 = 1d
  x1 += 1
  println(x1) // 2.0

  var x2 = 1f
  x2 += 1
  println(x2) // 2.0

}


