package scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object SetDefaultValueMethodParam extends App{

  val c = new Connection
  c.makeConnection()
  c.makeConnection(2000)
  c.makeConnection(3000, "https")


  //call methods with the names of the method parameters
  c.makeConnection(timeout=10000)
  c.makeConnection(protocol="https")
  c.makeConnection(timeout=10000, protocol="https")


  //Discussion

  //Note that you can’t set the protocol only with this approach,
  // but as shown in the Solution, you can use a named parameter
  c.makeConnection(protocol="https")


  val c2 = new Connection2
  //c2.makeConnection(1000)  //error
  //c2.makeConnection(timeout=1000)  //error
  //c2.makeConnection("https")  //error
  c2.makeConnection(protocol="https")
  c2.makeConnection(1000, "https")

  val c3 = new Connection3
  c3.makeConnection(1000)
  c3.makeConnection(1000, "https")

}

class Connection {
  def makeConnection(timeout: Int = 5000, protocol:String = "http") {
    println("timeout = %d, protocol = %s".format(timeout, protocol))
    // more code here
  }
}

class Connection2 {
  // intentional error
  def makeConnection(timeout: Int = 5000, protocol: String) {
    println("timeout = %d, protocol = %s".format(timeout, protocol))
    // more code here
  }
}


//By changing the method so the first field doesn’t have a default and the last field does,
//the default method call can now be used
class Connection3 {
  // corrected implementation
  def makeConnection(timeout: Int, protocol: String = "http") {
    println("timeout = %d, protocol = %s".format(timeout, protocol))
    // more code here
  }
}