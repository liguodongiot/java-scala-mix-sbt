package scalacookbook.chapter01

/**
 * 一次处理字符串的一个字符
 * Created by liguodong on 2016/6/6.
 */
object StringOneCharOneTime {
  def main(args: Array[String]) {
    val upper = "hello, world".map(c => c.toUpper)

    val upper2 = "hello, world".map(_.toUpper)

    val upper3 = "hello, world".filter(_ != 'l').map(_.toUpper)
    for (c <- "hello") println(c)

    val upper4 = for (c <- "hello, world") yield c.toUpper

    // for/yield loop
    val result = for {
      c <- "hello, world"
      if c != 'l'
    } yield c.toUpper

    "hello".foreach(println)

    // first example
    "HELLO".map(c => (c.toByte+32).toChar).foreach(println)

    // second example
    "HELLO".map{ c =>
      (c.toByte+32).toChar
    }.foreach(println)

    // use that method with map
    "HELLO".map(toLower)

    "HELLO".map(toLower _).foreach(print)
    println

    val s = "HELLO"
    for (c <- s) yield toLower(c)

    //function
    val toLower2 = (c: Char) => (c.toByte+32).toChar
    "HELLO".map(toLower2).foreach(print)
    println



    import Adler32Checksum._
    val sum = adler32sum("Wikipedia")
    printf("checksum (int) = %d\n", sum)
    printf("checksum (hex) = %s\n", sum.toHexString)



  }

  // write your own method that operates on a character
  def toLower(c: Char): Char = (c.toByte+32).toChar

}

//Adler-32校验算法
object Adler32Checksum {
  val MOD_ADLER = 65521

//  def main(args: Array[String]) {
//    val sum = adler32sum("Wikipedia")
//    printf("checksum (int) = %d\n", sum)
//    printf("checksum (hex) = %s\n", sum.toHexString)
//  }
  def adler32sum(s: String): Int = {
    var a = 1
    var b = 0
    s.getBytes.foreach{char =>
      a = (char + a) % MOD_ADLER
      b = (b + a) % MOD_ADLER
    }
    // note: Int is 32 bits, which this requires
    b * 65536 + a // or (b << 16) + a
  }
}

//You use foreach in this example instead of map, because the goal is to loop over each
//Byte in the String, and do something with each Byte, but you don’t want to return
//anything from the loop.
