package module.dsl

/**
  * Created by liguodong on 2016/11/17.
  */
object SampleMain {

  //只要该方法在当前范围内存在（通过当前import可见或是位于当前文件）
  //scala就会自动调用它，将int转换为DateHelper实例然后调用days方法
  import module.dsl.helper._
  implicit def convertInt2Date(number: Int) = new DateHelper(number)

  import module.dsl.love._
  implicit def conver(who: String) = new LoveHelper(who)

  def main(args: Array[String]): Unit = {
    import module.dsl.helper.DateHelper._

    val twoDayAgo = 2 days ago
    val twoDayAfter = 2 days from_now

    println("two days ago is " + twoDayAgo)
    println("two days after is " + twoDayAfter)

    import module.dsl.love.LoveHelper._
    I love You
    I love "marry"

  }

}


package helper {

  import java.util.Calendar
  import java.util.Date

  class DateHelper (number: Int) {

    def days(when: String): Date = {
      var date = Calendar.getInstance()
      when match {
        case DateHelper.ago => date.add(Calendar.DAY_OF_MONTH, -number)
        case DateHelper.from_now => date.add(Calendar.DAY_OF_MONTH, number)
        case _ => date
      }
      date.getTime()
    }

  }

  object DateHelper {

    val ago = "ago"

    val from_now = "from_now"

  }

}


package love {

  class LoveHelper (who: String) {

    def love(beLoved: String) = {
      beLoved match {
        case LoveHelper.You => println(who + " Love " + beLoved)
        case _ => println("You don't love " + beLoved )
      }

    }

  }

  object LoveHelper {

    val I = "I"

    val You = "You"

  }

}