package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/6.
 */
object CreateMullineString {
  def main(args: Array[String]) {
    val foo = """This is
    a multiline
    String"""

    println(foo)

    val speech = """Four score and
                   |seven years ago""".stripMargin

    println(speech)

    val speech2 = """Four score and
                   #seven years ago""".stripMargin('#')

    println(speech2)

    val speech3 = """Four score and
                   | seven years ago
                   | our fathers""".stripMargin.replaceAll("\r\n", " ")

    println(speech3)  //Four score and seven years ago our fathers

    val s = """This is known as a
              | "multiline" string
              | or 'heredoc' syntax.""". stripMargin.replaceAll("\r\n", " ")
    println(s)  //This is known as a "multiline" string or 'heredoc' syntax.
  }
}
