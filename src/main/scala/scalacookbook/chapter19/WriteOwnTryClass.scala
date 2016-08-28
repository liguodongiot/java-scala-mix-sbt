package scalacookbook.chapter19



/**
  * Created by liguodong on 2016/8/27.
  */
object WriteOwnTryClass extends App{

  //val x = Attempt("10".toInt) // Succeeded(10)
  //val y = Attempt("10A".toInt) // Failed(Exception)
  import scalacookbook.chapter19.section0802._
  val x = Attempt(1/0)
  val result = x.getOrElse(0)

  val y = Attempt("foo".toInt).getOrElse(0)

  val z = Attempt("123".toInt).getOrElse(0)

  println(x)
  println(result)
  println(y)
  println(z)

  //The Scala 2.10 Try classes
  //def getOrElse[U >: T](default: => U): U = if (isSuccess) get else default
  //def map[U](f: T => U): Try[U] = Try[U](f(value))
  //def flatten[U](implicit ev: T <:< Try[U]): Try[U] = value

}

package section0801{

  // version 1
  sealed class Attempt[A]
  object Attempt {
    def apply[A](f: => A): Attempt[A] =
      try {
        val result = f
        return Succeeded(result)
      } catch {
        case e: Exception => Failed(e)
      }
  }
  final case class Failed[A](val exception: Throwable) extends Attempt[A]
  final case class Succeeded[A](value: A) extends Attempt[A]

}

package section0802{
  // version 2
  sealed abstract class Attempt[A] {

    def getOrElse[B >: A](default: => B): B = if (isSuccess) get else default

    var isSuccess = false

    def get: A
  }
  object Attempt {
    def apply[A](f: => A): Attempt[A] =
      try {
        val result = f
        Succeeded(result)
      } catch {
        case e: Exception => Failed(e)
      }
  }

  final case class Failed[A](val exception: Throwable) extends Attempt[A] {
    isSuccess = false
    def get: A = throw exception
  }

  final case class Succeeded[A](result: A) extends Attempt[A] {
    isSuccess = true
    def get = result
  }
}