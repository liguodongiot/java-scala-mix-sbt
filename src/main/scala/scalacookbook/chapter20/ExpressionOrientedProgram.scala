package scalacookbook.chapter20

/**
  * Created by liguodong on 2016/8/27.
  */
object ExpressionOrientedProgram extends App{

  // understand the difference between a statement and an expression.
  //Statements do not return results and are executed solely for their side effects,
  //while expressions always return a result and often do not have side effects at all.


  //statements
  /*
  order.calculateTaxes()
  order.updatePrices()
  */

  //Expressions
  /*
  val tax = calculateTax(order)
  val price = calculatePrice(order)
  */
  import section03._
  val stock = new Stock("GOOG", "Google", "", "", "", "")
  val url = stock.buildUrl(stock.symbol)
  stock.html = stock.getUrlContent(url)
  // a series of calls on an object ('statements')
  stock.setPriceUsingHtml
  stock.setVolumeUsingHtml
  stock.setHighUsingHtml
  stock.setLowUsingHtml


  import section01._
  // a series of expressions
  val url2 = StockUtils.buildUrl(stock.symbol)
  val html = NetUtils.getUrlContent(url2)
  val price = StockUtils.getPrice(html)
  val volume = StockUtils.getVolume(stock.symbol,html)
  val high = StockUtils.getHigh(stock.symbol,html)
  val low = StockUtils.getLow(stock.symbol,html)
  val date = DateUtils.currentDate
  val stockInstance = StockInstance2(stock.symbol, date, price, high, low)


  //Discussion
  println(2 + 2)
  println(List(1,2,3,4,5).filter(_ > 2))

  val a=1
  val b=2
  //an if/else expression returns a value
  val greater = if (a > b) a else b

  //Match expressions also return a result
  val evenOrOdd = b match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }


  //Even a try/catch block returns a value
  val result = try {
    "1".toInt
  } catch {
    case _ => 0
  }

  /*
  Because expressions always return a result, and generally don’t have side effects, there
  are several benefits to EOP:
  • The code is easier to reason about. Inputs go in,
    a result is returned, and there are no side effects.
  • The code is easier to test.
  • Combined with Scala’s syntax, EOP also results in concise, expressive code.
  • Although it has only been hinted at in these examples, expressions can often be
    executed in any order. This subtle feature lets you execute expressions in parallel,
    which can be a big help when you’re trying to take advantage of modern multicore CPUs.
  */


}


package section03{
  // an intentionally bad example
  class Stock (var symbol: String,
               var company: String,
               var price: String,
               var volume: String,
               var high: String,
               var low: String) {
    var html: String = _
    def buildUrl(stockSymbol: String): String = { "" }
    def getUrlContent(url: String):String = { "" }
    def setPriceUsingHtml() { this.price = "" }
    def setVolumeUsingHtml() { this.volume = "" }
    def setHighUsingHtml() { this.high = "" }
    def setLowUsingHtml() { this.low = "" }
  }


}
