package module.detailtrait

/**
  * 在对象中混入trait
  * Created by liguodong on 2016/10/9.
  */
object ObjectMixTrait extends App{

  import section._

  println("===================aaaaaa========================");
  // 类本身与记录日志Logger没有关系，但是在对象中混入trait的代码后，就具备了日志的功能
  val actionA = new TraitActionImpl with WriteLogger;
  val op = "业务操作";
  actionA.doAction(op);
  actionA.log(op);

  println("===================bbbbbb========================");
  // 类实现了Logger，但日志记录是空的操作
  val loggerA = new LoggerActionImpl;
  loggerA.doAction(op);

  println("===================cccccc========================");
  // 类实现了Logger，通过在类定义中混入trait实现了自己的日志功能
  val loggerB = new LoggerActionImpl with WriteLogger;
  loggerB.doAction(op);

  //比Java的接口方便多了
}



package section{

  /**
    * 单独的日志模块
    * 只是标识要记录日志，但没有明确定义如何记录日志
    */
  trait Logger {
    def log (msg : String) {}
  }


  /**
    * 记录日志的具体实现类
    */
  trait WriteLogger extends Logger {
    override def log (msg : String) = println("WriteLogger : " + msg)
  }

  /**
    * 需要执行的业务操作
    */
  trait Action {
    def doAction(action : String)
  }

  class TraitActionImpl extends Action {
    override def doAction(op : String) = println(op)
  }

  class LoggerActionImpl extends Action with Logger {
    override def doAction(op : String) = {
      println(op)
      // 如果确实需要日志功能但暂不清楚以何种形式记录日志时，可以采用该方法；
      // 当明确了记录日志的方式后，再通过如下在对象中混入trait实现。
      log(op)
    }
  }

}
