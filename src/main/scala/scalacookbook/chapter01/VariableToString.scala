package scalacookbook.chapter01

/**
 * 变量变成字符串
 * Created by liguodong on 2016/6/6.
 */


object VariableToString {
  def main(args: Array[String]) {

    val name = "Fred"

    val age = 33

    val weight = 200.00


    //s is a method
    println(s"$name is $age years old, and weighs $weight pounds.")
    println(s"Age next year: ${age + 1}")
    println(s"You are 33 years old: ${age == 33}")

    case class Student(name: String, score: Int)
    val hannah = Student("Hannah", 95)
    println(s"${hannah.name} has a score of ${hannah.score}")

    // error: this is intentionally wrong 这是一个如意的错误
    println(s"$hannah.name has a score of $hannah.score")

    //The f string interpolator(printf style formatting)
    println(f"$name is $age years old, and weighs $weight%.2f pounds.")

    println(f"$name is $age years old, and weighs $weight%.0f pounds.")

    val out = f"$name, you weigh $weight%.0f pounds."
    println(out)

    println
    //Scala 2.10新增了raw插值函数，用于处理转义字符
    println(s"foo\nbar")

    println

    println(raw"foo\nbar")

    println

    //2.10之前的版本
    val s = "%s is %d years old".format(name, age)
    println("%s is %d years old".format(name, age))





  }
}
