package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/20.
 */
object LoopWithForAndForeach extends App{

  val a = Array("apple", "banana", "orange")

  for (e <- a) println(e)
  println("~~~~~~~~")

  //Returning values from a for loop
  for (e <- a) {
    // imagine this requires multiple lines
    val s = e.toUpperCase
    println(s)
  }

  val newArray = for (e <- a) yield e.toUpperCase


  println(newArray(0))

  for(i<-newArray) println(i)


  val newArray2 = for (e <- a) yield {
    // imagine this requires multiple lines
    val s = e.toUpperCase
    s
  }

  println
  //for loop counters


  for (i <- 0 until a.length) {
    println(s"$i is ${a(i)}")
  }

  for ((e, count) <- a.zipWithIndex) {
    println(s"$count is $e")
  }


  //Generators and guards
  for (i <- 1 to 3) println(i)

  1 to 3

  for (i <- 1 to 10 if i % 4==0) println(i)

  //Looping over a Map

  val names = Map("fname" -> "Robert",
    "lname" -> "Goren")
  for ((k,v) <- names) println(s"key: $k, value: $v")


  //Discussion
  a.foreach(println)


  //before
  a.foreach { e =>
    val s = e.toUpperCase
    println(s)
  }

  //after
  a.foreach(e => println(e.toUpperCase))


  // original List code
  val nums = List(1,2,3)
  for (i <- nums) println(i)

  // translation performed by the compiler
  nums.foreach(((i) => println(i)))

  // #1 - input (my code)
  for (i <- 1 to 10) println(i)

  // #1 - compiler output
  1.to(10).foreach(((i) => println(i)))



  // #2 - input code
  for {
    i <- 1 to 10
    if i % 2 == 0
  } println(i)

  // #2 - translated output

  1.to(10).withFilter(i=>i%2==0).foreach(((i) =>
    println(i)))


  // #3 - input code
  for {
    i <- 1 to 10
    if i != 2
    if i % 2 == 0
  } println(i)

  // #3 - translated output
  1.to(10).withFilter(((i) => i!=2))
    .withFilter(((i) => i % 2 == 0)).foreach(((i) => println(i)))

  // #4 - input code
  for { i <- 1 to 10 } yield print(i)
  println

  // #4 - output
  1.to(10).map(((i) => print(i)))
  println

  // #5 - input code (for loop, guard, and yield)
  for {
    i <- 1 to 10
    if i % 2 == 0
  } yield print(i)

  println

  // #5 - translated code
  1.to(10).withFilter(((i) => i % 2 == 0)).map(((i) => print(i)))

  println
}
