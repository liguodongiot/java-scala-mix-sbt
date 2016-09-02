package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/12.
 */
object HandleLargeNum extends App{

  var b = BigInt(1234567890)
  var b2 = BigDecimal(123456.789)

  println("b = "+b)

  println(b + b)

  println("b * b = "+(b * b))

  println(b += 1)

  // convert them to other numeric types
  println(b.toInt)
  println(b.toLong)
  println(b.toFloat)
  println(b.toDouble)

  // To help avoid errors, you can also test them first to see
  // if they can be converted to other numeric types
  println(b.isValidByte)
  println(b.isValidChar)
  println(b.isValidShort)
  println(if (b.isValidInt) b.toInt)


  //check the maximum values
  println(Byte.MaxValue)
  println(Short.MaxValue)
  println(Int.MaxValue)
  println( Long.MaxValue)
  println(Double.MaxValue)


  //you may also be able to use the PositiveInfinity and
  //NegativeInfinity of the standard numeric types
  //正无穷大
  println(Double.PositiveInfinity)
  //负无穷大
  println(Double.NegativeInfinity)

  println(1.7976931348623157E308 > Double.PositiveInfinity)


}
