package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/12.
 */
object CompareFloatPointNum {

  def main(args: Array[String]) {
    val a = 0.3         //a: Double = 0.3
    println(a)
    val b = 0.1 + 0.2   //b: Double = 0.30000000000000004
    println(b)

    //判断浮点数是否相等
    println(~=(a, b, 0.0001))    //res0: Boolean = true
    println(~=(b, a, 0.0001))    //res1: Boolean = true

    val c = 0.1+0.1
    println(c)

    println(a == b)

    //隐式转换
    //define an implicit conversion to add a method like this to the Double class
    import DoubleUtils._
    println(a.~=(b))
    println(a ~= b)

    //或者 add the same method to a utilities object
    println(MathUtils.~=(a, b, 0.000001))  //不是一种好的方式


  }


  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }

}

//工具类
object MathUtils {
  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }
}



object DoubleUtils{

  /*
   With an implicit conversion, the name ~= is very readable,
   but in a utilities object like this,
   it doesn’t look quite right,
   so it might be better named approximatelyEqual,
   equalWithinTolerance, or some other name.
   采用工具类看起来并不十分正确。
  */
  implicit class EqualFloatNum(a: Double) {

    def ~=(b: Double) = if ((a - b).abs < 0.000001) true else false

  }
}
