package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/5.
 */
object TestStringEqual {

  def main(args: Array[String]) {
    val s1 = "Hello"
    val s2 = "Hello"
    val s3 = "H"+"ello"
    println(s1==s2)
    println(s1==s3)
    println(s2==s3)


    val s4:String = null
    println(s3==s4)
    println(s4==s3)


    val s5 = "Liguodong"
    val s6 = "liguodong"
    println(s5.toUpperCase==s6.toUpperCase)

    val ss1:String = null
    val ss2:String = null
    //java.lang.NullPointerException
    //println(ss1.toLowerCase==ss2.toLowerCase)

    val si1 = "China"
    val si2 = "china"
    println(si1.equalsIgnoreCase(si2))

  }
}
