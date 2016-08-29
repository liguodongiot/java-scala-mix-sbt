package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/6.
 */
object CreateMullineString {
  def main(args: Array[String]) {
    val foo = """This is
    a multiline
    String"""

    println("[MullineString]\n"+foo)

    val speech = """Four score and
                   |seven years ago""".stripMargin

    println("[stripMargin]\n"+speech)

    val speech2 = """Four score and
                   #seven years ago""".stripMargin('#')

    println("[stripMargin('#')]\n"+speech2)

    //注：换行有时是\r\n  有时是\n
    val speech3 = """Four score and
                   | seven years ago
                   | our fathers""".stripMargin.replaceAll("\r\n", " ")

    println("[stripMargin/replaceAll]\n"+speech3)  //Four score and seven years ago our fathers

    //包括单引号或双引号
    val s = """This is known as a
              | "multiline" string
              | or 'heredoc' syntax.""".stripMargin.replaceAll("\n", " ")
    println(s)  //This is known as a "multiline" string or 'heredoc' syntax.
  }
}
