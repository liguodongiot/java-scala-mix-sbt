package scalacookbook.chapter07

/**
  * Created by liguodong on 2016/7/17.
  */
object UseStaticImports extends App{

  //Use this syntax to import all members of the Java Math class
  import java.lang.Math._

  val a = sin(0)
  println(a)

  val pi = cos(PI)
  println(pi)


  import java.awt.Color._
  println(RED)
  val currentColor = BLUE
  println(currentColor)

  //Given a Java enum
  import scalacookbook.chapter07.dates.Day._
  val date = SUNDAY
  // somewhere after the import statement
  if (date == SUNDAY || date == SATURDAY)
    println("It's the weekend.")
  else
    println("xixi")


}



