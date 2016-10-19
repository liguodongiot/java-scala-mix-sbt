package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */

object ProvideDefaultValueForConstructParam extends App{

  import section05._

  val s = new Socket
  println(s.timeout)

  val s2 = new Socket(5000)
  println(s2.timeout)

  val s3 = new Socket(timeout=5000)
  println(s3.timeout)


  //Discussion
  println(new Socket2)
  println(new Socket2(3000))

  println("~~~~~~~~~~~~")
  println(new Socket3(3000, 4000))
  println("~~~~~~~~~~~~")

  //Using named parameters
  // provide the names of constructor parameters when creating objects
  println(new Socket3(timeout=3000, linger=4000))
  println(new Socket3(linger=4000, timeout=3000))
  println(new Socket3(timeout=3000))
  println(new Socket3(linger=4000))
}

package section05{

  class Socket (val timeout: Int = 10000)

  //a primary one-arg constructor and an auxiliary zero-args constructor
  class Socket2(val timeout: Int) {

    def this() = this(10000)
    override def toString = s"timeout: $timeout"
  }

  //Multiple parameters
  class Socket3(val timeout: Int = 1000, val linger: Int = 2000) {
    override def toString = s"timeout: $timeout, linger: $linger"
  }

}












