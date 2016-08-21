package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/12.
 */
object GenerateRandomNum extends App{

  //Create random numbers
  val r = scala.util.Random
  println(r.nextInt)

  //limit the random numbers to a maximum value
  println(r.nextInt(100))

  // returns a value between 0.0 and 1.0
  println(r.nextFloat)

  // returns a value between 0.0 and 1.0
  println(r.nextDouble)

  //You can set the seed value using an Int or Long when creating the Random object
  val rSeed = new scala.util.Random(100)

  //You can also set the seed value after a Random object has been created
  rSeed.setSeed(1000L)

  println(rSeed.nextInt())


  // random characters
  println(r.nextPrintableChar)

  println(r.nextPrintableChar)

  // create a random length range
  var range = 0 to r.nextInt(10)

  println("length range:"+range)

  range = 0 to r.nextInt(10)
  println("length range:"+range)


  //You can add a for/yield loop to modify the numbers:
  for (i <- 0 to r.nextInt(10)) yield println(i * 2)
  println("=~=~=~=~=")

  //Here’s a random-length collection of up to 10 Float values
  for (i <- 0 to r.nextInt(10)) yield println(i * r.nextFloat)

  println("++++~~~~++++~~~~")

  //Here’s a random-length collection of “printable characters”
  for (i <- 0 to r.nextInt(10)) yield print(r.nextPrintableChar)


  //create a sequence of known length, filled with random numbers:
  for (i <- 1 to 5) yield println(r.nextInt(100))


}
