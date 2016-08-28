package scalacookbook.chapter20

/**
  * Created by liguodong on 2016/8/27.
  */
object PureFunctions extends App {

  //关于纯函数的陈述
  //1、一个或多个输入参数。
  //2、结果完全基于这些参数和算法，该算法不会在类或者对象中包含任何隐藏的状态。
  //3、不会改变给定的参数。
  //4、不会改变class或者object的状态。
  //5、不执行任何I/O操作，如从磁盘读取、写入磁盘、提示输入、读取输入。

  //例子
  //数学函数，如 addition, subtraction, multiplication.
  //String类的方法，如split, length.
  //String类的to*方法（toInt, toDouble等）.
  //不可变集合的方法，如map, drop, take, filter等

  import section01._

  StockInstance("AAPL", "Nov. 2, 2012 5:00pm", 576.80, 20431707)


  val stock = new Stock("AAPL", "Apple")
  val url = StockUtils.buildUrl(stock.symbol)
  val html = NetUtils.getUrlContent(url)

  // First, retrieve the HTML that describes the stock from a web page
  val price = StockUtils.getPrice(html)
  val volume = StockUtils.getVolume(stock.symbol,html)
  val high = StockUtils.getHigh(stock.symbol,html)
  val low = StockUtils.getLow(stock.symbol,html)
  val date = DateUtils.currentDate
  val stockInstance = StockInstance2(stock.symbol, date, price, high, low)


  // eliminate all the intermediate variables
  val html2 = NetUtils.getUrlContent(url)
  val stockInstance3 = StockInstance3(
    stock.symbol,
    DateUtils.currentDate,
    StockUtils.getPrice(html),
    StockUtils.getVolume(stock.symbol,html)
  )
}

package section01{
  case class Stock(symbol: String, company: String)

  case class StockInstance(symbol: String,
                           datetime: String,
                           price: BigDecimal,
                           volume: Long)

  case class StockInstance2(symbol: String,
                           datetime: String,
                           price: String,
                           high: String,
                           low: String
                          )
  case class StockInstance3(symbol: String,
                           datetime: String,
                           price: String,
                           volume: String)

  object NetUtils {
    def getUrlContent(url: String): String = { "" }
  }

  object StockUtils {
    def buildUrl(stockSymbol: String): String = { "" }
    def getPrice(html: String): String = { "" }
    def getVolume(symbol: String, html: String): String = { "" }
    def getHigh(symbol: String, html: String): String = { "" }
    def getLow(symbol: String, html: String): String = { "" }
  }

  object DateUtils {
    def currentDate: String = { "" }
    def currentTime: String = { "" }
  }

}

