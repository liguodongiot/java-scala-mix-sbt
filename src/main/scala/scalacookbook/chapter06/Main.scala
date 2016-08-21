package scalacookbook.chapter06

/**
 * Created by liguodong on 2016/7/5.
 */
object Main extends App{

  type Throwable = java.lang.Throwable
  type Exception = java.lang.Exception
  type Error = java.lang.Error
  type Seq[+A] = scala.collection.Seq[A]
  val Seq = scala.collection.Seq

  case class Person(name:String)

  val siblings = List(Person("Kim"), Person("Julia"), Person("Kenny"))

}
