package scalacookbook.chapter07

/**
  * Created by liguodong on 2016/7/17.
  */
object UseStaticImports extends App{

  //Use this syntax to import all members of the Java Math class
  import java.lang.Math._

  val a = sin(0)

  val pi = cos(PI)

  import java.awt.Color._
  import java.awt.Color._
  println(RED)
  val currentColor = BLUE


  import dates.Day._
  val date = SUNDAY
  // somewhere after the import statement
  if (date == SUNDAY || date == SATURDAY)
    println("It's the weekend.")
  else
    println("xixi")


}



