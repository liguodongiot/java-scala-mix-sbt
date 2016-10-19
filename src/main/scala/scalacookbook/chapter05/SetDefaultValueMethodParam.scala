package scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object SetDefaultValueMethodParam extends App{

  import section03._

  val c = new Connection
  c.makeConnection()
  c.makeConnection(2000)
  c.makeConnection(3000, "https")

  //指定方法参数名
  //call methods with the names of the method parameters
  c.makeConnection(timeout=10000)
  c.makeConnection(protocol="https")
  c.makeConnection(timeout=10000, protocol="https")

  println("---------Discussion-----------")
  //Discussion

  //Note that you can’t set the protocol only with this approach,
  // but as shown in the Solution, you can use a named parameter
  c.makeConnection(protocol="https")

  println("------------------------------")

  val c2 = new Connection2
  //c2.makeConnection(1000)  //error
  //c2.makeConnection(timeout=1000)  //error
  //c2.makeConnection("https")  //error
  c2.makeConnection(protocol="httpsxxx")
  c2.makeConnection(1001, "httpsxxx")

  val c3 = new Connection3
  c3.makeConnection(1003)
  c3.makeConnection(1005, "httpsdddd")

}

package section03{

  class Connection {
    //设置默认值
    def makeConnection(timeout: Int = 5000, protocol:String = "http") {
      println("timeout = %d, protocol = %s".format(timeout, protocol))
      // more code here
    }
  }

  class Connection2 {
    //第二个参数没有默认值
    // intentional error
    def makeConnection(timeout: Int = 5000, protocol: String) {
      println("timeout = %d, protocol = %s".format(timeout, protocol))
      // more code here
    }
  }

  //第一个参数没有默认值
  //By changing the method so the first field doesn’t have a default and the last field does,
  //the default method call can now be used
  class Connection3 {
    // corrected implementation
    def makeConnection(timeout: Int, protocol: String = "http") {
      println("timeout = %d, protocol = %s".format(timeout, protocol))
      // more code here
    }
  }
}

