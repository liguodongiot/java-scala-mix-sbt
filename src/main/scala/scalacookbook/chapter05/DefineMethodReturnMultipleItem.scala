package scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object DefineMethodReturnMultipleItem extends App{


  def getStockInfo = {
    // other code here ...
    ("NFLX", 100.00, 101.00) // this is a Tuple3
  }

  val (symbol, currentPrice, bidPrice) = getStockInfo
  println("Tuples: "+symbol+" "+currentPrice+" "+bidPrice)



  //Discussion

/*
  // java
  public class StockInfo {
    String symbol;
    double currentPrice;
    double bidPrice;
    public StockInfo(String symbol, double currentPrice, double bidPrice) {
    this.symbol = symbol;
    this.currentPrice = currentPrice;
    this.bidPrice = bidPrice;
    }
  }

  Then you could return an instance of this class from a method, like this:
  return new StockInfo("NFLX", 100.00, 101.00);
*/
  def returnStockInfo = {
    new StockInfo("NFLX", 100.00, 101.00);
  }
  val retStockInfo = returnStockInfo
  println(retStockInfo.getSymbol +" "+retStockInfo.getCurrentPrice+" "+retStockInfo.getBidPrice)

  //Working with tuples

  //return only two elements from a method
  def twoParam = ("NFLX", 100.00)
  val (a, b) = twoParam


  //使用下划线语法访问元组值
  val result = twoParam
  println(result._1)
  println(result._2)



}
