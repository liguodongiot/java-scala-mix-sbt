package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */
object PreventGetSetGenerated extends App{

  import section07._

  //Discussion
  val s1 = new StockDis
  s1.setPrice(20)
  println(s1.getPrice())

  val s2 = new StockDis
  s2.setPrice(100)
  println(s2.getPrice())

  println(s2.isHigher(s1))

  //Object-private fields 对象私有属性
  //private[this]



}

package section07{

  class Stock {
    // getter and setter methods are generated
    var delayedPrice: Double = _

    // keep this field hidden from other classes
    private var currentPrice: Double = _
  }
  //Compiled from "Stock.scala"

  //public class Stock extends java.lang.Object implements scala.ScalaObject{
  //  public double delayedPrice();
  //  public void delayedPrice_$eq(double);
  //  public Stock();
  //}

  class StockDis {
    // a private field can be seen by any Stock instance
    private var price: Double = _

    def setPrice(p: Double) { price = p }

    def getPrice():Double = {
      price
    }


    def isHigher(that: StockDis): Boolean = this.price > that.price
  }


  class StockObj {
    // a private[this] var is object-private, and can only be seen
    // by the current instance
    private[this] var price: Double = _

    def setPrice(p: Double) { price = p }

    // error: this method won't compile because price is now object-private
    //def isHigher(that: StockObj): Boolean = this.price > that.price
  }




}





