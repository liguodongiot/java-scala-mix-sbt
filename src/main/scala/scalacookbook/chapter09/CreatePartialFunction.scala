package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/24.
  */
object CreatePartialFunction extends App{

  //val divide = (x: Int) => 42 / x
  //println(divide(0))

  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }

  println(divide.isDefinedAt(1))
  if (divide.isDefinedAt(1)) println(divide(1))
  println(divide.isDefinedAt(0))


  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  println(divide2.isDefinedAt(0))
  println(divide2.isDefinedAt(1))

  println("-------------------")

  //The PartialFunction explained

  //trait PartialFunction[-A, +B] extends (A) => B

  // converts 1 to "one", etc., up to 5
  val convertLowNumToString = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    def apply(i: Int) = nums(i-1)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }

  if(convertLowNumToString.isDefinedAt(5)) { println(convertLowNumToString(5)) }

  if(convertLowNumToString.isDefinedAt(6)) { println(convertLowNumToString(6)) }

  println("++++++++++++++++++++++")

  //orElse and andThen

  // converts 1 to "one", etc., up to 5
  val convert1to5 = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    def apply(i: Int) = nums(i-1)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }
  // converts 6 to "six", etc., up to 10
  val convert6to10 = new PartialFunction[Int, String] {
    val nums = Array("six", "seven", "eight", "nine", "ten")
    def apply(i: Int) = nums(i-6)
    def isDefinedAt(i: Int) = i > 5 && i < 11
  }

  val handle1to10 = convert1to5 orElse convert6to10

  println(handle1to10.isDefinedAt(10))
  println(handle1to10.isDefinedAt(15))
  println(handle1to10(3))
  println(handle1to10(8))

  println("---------------------")

  //Discussion
  val divide3: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  //MatchError
  //List(0,1,2) map { divide3 }

  //it works fine, because the collect method is written to
  // test the isDefinedAt method for each element it’s given.

  List(0,1,2) collect { divide3 } foreach println

  println("xxxxxxxxxx")

  List(0,1,2).collect(divide3).foreach(println)

  println("===============")

  List(42, "cat") collect { case i: Int => i + 1 } foreach println

  List(42, "cat").collect({case i: Int => i + 1}).foreach(println)

  println("===============")

  val sample = 1 to 5
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  }

  val evenNumbers = sample collect isEven foreach println

  println("~~~~~~~~~~~")

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x + " is odd"
  }
  println("~~~~~~~~~~~")

  val numbers = sample map (isEven orElse isOdd) foreach(println)

  println("~~~~~~~~~~~")
}
