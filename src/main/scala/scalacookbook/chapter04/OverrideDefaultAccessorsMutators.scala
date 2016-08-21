package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */

object OverrideDefaultAccessorsMutators extends App{

  /*
  // error: this won't work
  class Person(private var name: String) {
    // this line essentially creates a circular reference
    def name = name
    def name_=(aName: String) { name = aName }
  }
  */

  //常见的方法是在参数名前面添加一个下划线
  class Person(private var _name: String) {
    //然后根据Scala规定声明getter和setter方法
    def name = _name // accessor
    def name_=(aName: String) { _name = aName } // mutator

  }
  val p = new Person("Jonathan")
  p.name = "Jony" // setter
  println(p.name) // getter


  println("============================")

  class Stock (var symbol: String)

  //$ javap Stock
  //  public class Stock extends java.lang.Object{
  //    public java.lang.String symbol();
  //    public void symbol_$eq(java.lang.String);
  //    public Stock(java.lang.String);
  //  }

  //symbol_$eq  <====> symbol_=
  //stock.symbol = "GOOG" <====> stock.symbol_$eq("GOOG")

}

