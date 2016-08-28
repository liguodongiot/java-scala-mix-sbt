package scalacookbook.chapter20

import scala.io.Source

/**
  * Created by liguodong on 2016/8/28.
  */
object UsingOptionSomeNonePattern extends App {

  //Returning an Option from a method
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }
  println(toInt("adf"))

  //Getting the value from an Option
  val x = toInt("1").getOrElse(0)
  println(x)

  //Because an Option is a collection with zero or one elements,
  // the foreach method can be used in many situations.
  toInt("1").foreach{ i =>
    println(s"Got an int: $i")
  }

  // access the toInt result is with a match expression
  toInt("1") match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }

  //Using Option with Scala collections
  val bag = List("1", "2", "foo", "3", "bar")
  //convert every element in the collection into a Some or None value
  println(bag.map(toInt))
  //an Option is a collection of zero or one elements,
  // you can convert this list of Int values by adding flatten to map.
  println(bag.map(toInt).flatten)
  println(bag.flatMap(toInt))

  //The collect method provides another way to achieve the same result.
  println(bag.map(toInt).collect{case Some(i) => i})


  //Using Option with other frameworks
  /*
  def getAll() : List[Stock] = {
    DB.withConnection { implicit connection =>
      sqlQuery().collect {
        // the 'company' field has a value
        case Row(id: Int, symbol: String, Some(company: String)) =>
          Stock(id, symbol, Some(company))
        // the 'company' field does not have a value
        case Row(id: Int, symbol: String, None) =>
          Stock(id, symbol, None)
      }.toList
    }
  }
  */

  /*
  verifying("If age is given, it must be greater than zero",
    model =>
      model.age match {
        case Some(age) => age < 0
        case None => true
      }
  )
  */

  //Using Try, Success, and Failure
  import scala.util.{Try,Success,Failure}
  def divideXByY(x: Int, y: Int): Try[Int] = {
    Try(x / y)
  }
  println("divideXByY(1,1):"+divideXByY(1,1))
  println("divideXByY(1,0):"+divideXByY(1,0))

  // If you don’t care about the error message and just want a result,use getOrElse
  // Success
  val x2 = divideXByY(1, 1).getOrElse(0)
  // Failure
  val y2 = divideXByY(1, 0).getOrElse(0)
  println(x2+"----"+y2)

  //Using a foreach method also works well
  divideXByY(1, 1).foreach(println)
  divideXByY(1, 0).foreach(println)

  //If you’re interested in the Failure message,
  //one way to get it is with a match expression.
  divideXByY(1, 1) match {
    case Success(i) => println(s"Success, value is: $i")
    case Failure(s) => println(s"Failed, message is: $s")
  }

  //Another approach is to see if a Failure was returned,
  // and then call its toString method
  val xx = divideXByY(1,0)
  if (xx.isFailure) println(xx.toString)


  //The Try class has the added benefit that you can chain operations together,
  // catching exceptions as you go.
  val xxx = "13"
  val yyy = "12"
  val z = for {
    a <- Try(xxx.toInt)
    b <- Try(yyy.toInt)
  } yield a * b
  val answer = z.getOrElse(0) * 2
  println(answer)

  def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
  }
  //If the readTextFile method runs successfully,
  // the lines from the /etc/passwd file are printed,
  // but if an exception happens while trying to open and read the file,
  // the Failure line in the match expression prints the error, like this:


  //The Try class includes a nice collection of methods that
  // let you handle situations in many ways:
  //Collection-like implementations of filter, flatMap, flatten, foreach, and map
  // get, getOrElse, and orElse
  //toOption, which lets you treat the result as an Option
  //recover, recoverWith, and transform, which let you gracefully handle Success and Failure results

  //Using Either, Left, and Right
  //Prior to Scala 2.10, an approach similar to Try was available
  // with the Either, Left, and Right classes.

  def divideXByY2(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Dude, can't divide by 0")
    else Right(x / y)
  }

  val aa = divideXByY2(1, 1).right.getOrElse(0) // returns 1
  val bb = divideXByY2(1, 0).right.getOrElse(0) // returns 0

  // prints "Answer: Dude, can't divide by 0"
  divideXByY2(1, 0) match {
    case Left(s) => println("Answer: " + s)
    case Right(i) => println("Answer: " + i)
  }
  val dxy = divideXByY2(1, 0)
  println(dxy)
  println(dxy.isLeft)
  println(dxy.left)

  //Discussion
  //Don’t use the get method with Option
  val jj = toInt("5").get

  //this isn’t any better than a NullPointerException
  //val kk = toInt("foo").get

  //test the value before trying to access it
  // don't do this
  //val pp = if (toInt("foo").isDefined) toInt("foo") else 0

  //The preferred approaches are to use getOrElse, a match expression, or foreach.

}
