package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/11.
 */





object ParseNumFromString extends App{

  val aInt = "100".toInt

  val aDouble = "100".toDouble

  val aFloat = "100".toFloat

  val aLong = "1".toLong

  val aShort = "1".toShort

  val aByte = "1".toByte

  println(aInt.getClass.getName+" "+aInt)
  println(aDouble.getClass.getName+" "+aDouble)
  println(aFloat.getClass.getName+" "+aFloat)
  println(aLong.getClass.getName+" "+aLong)
  println(aShort.getClass.getName+" "+aShort)
  println(aByte.getClass.getName+" "+aByte)

  val bInt = BigInt("1")
  val bDecimal = BigDecimal("3.14159")
  println(bInt.getClass.getName+" "+bInt)
  println(bDecimal.getClass.getName+" "+bDecimal)


  println(Integer.parseInt("1", 2)) //二进制转换成整数
  println(Integer.parseInt("10", 2))
  println(Integer.parseInt("-FF", 16))//十六进制转换成整数
  println(Integer.parseInt("100", 2))

  println("======================")

  import StringUtils._
  println("11".toIntRadix(2))
  println("100".toIntRadix(16))

  //def toInt: Int         = java.lang.Integer.parseInt(toString)
  println("100".toInt)


  println(toIntException("1").getOrElse(0)) // 1
  println(toIntException("a").getOrElse(0)) // 0

  val aString = "100"

  toIntException(aString) match {
    case Some(n) => println(n)
    case None => println("Boom! That wasn't a number.")
  }


  val result = toIntException(aString) match {
    case Some(x) => x
    case None => 0 // however you want to handle this
  }
  println(result)
}




object StringUtils{
  implicit class StringToInt(s: String) {
    //因为String中已经有toInt方法了，因此，不能再写成toInt方法
    def toIntRadix(radix: Int) = Integer.parseInt(s, radix)

  }

  def toIntException(s: String):Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: NumberFormatException => None
    }
  }
}
