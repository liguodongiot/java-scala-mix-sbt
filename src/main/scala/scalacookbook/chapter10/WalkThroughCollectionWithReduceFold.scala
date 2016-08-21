package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/26.
  */
object WalkThroughCollectionWithReduceFold extends App  {

  val a = Array(12, 6, 15, 2, 20, 9)

  val sum = a.reduceLeft(_ + _)
  println(sum)

  println(a.reduceLeft((x,y) => x + y))

  println(a.reduceLeft(_ * _))

  println(a.reduceLeft(_ min _)+" , "+a.reduceLeft(_ max _))

  //Show each step in the process
  // returns the max of the two elements
  val findMax = (x: Int, y: Int) => {
    val winner = x max y
    println(s"compared $x to $y, $winner was larger")
    winner
  }

  a.reduceLeft(findMax)

  val seq = Array(2,3,5,10,6,7);

  def f(a:Int,b:Int):Int = {
    var max = a;
    if(b>max) max = b;
    max
  }

  // you provide the sequence 'seq' and the function 'f'
  var result = seq(0)
  for (i <- 1 until seq.length) {
    val next = seq(i)
    result = f(result, next)
  }

  //Working with other sequences and types
  val peeps = Vector("al", "hannah", "emily", "christina", "aleka")

  // longest
  peeps.reduceLeft((x,y) => if (x.length > y.length) x else y)

  // shortest
  peeps.reduceLeft((x,y) => if (x.length < y.length) x else y)


  //foldLeft, reduceRight, and foldRight
  val aa = Array(1, 2, 3)
  println(aa.reduceLeft(_ + _))

  println(aa.foldLeft(20)(_ + _))

  println(aa.foldLeft(100)(_ + _))

  //The difference between reduceLeft and reduceRight
  val divide = (x: Double, y: Double) => {
    val result = x / y
    println(s"divided $x by $y to yield $result")
    result
  }

  val b = Array(1.0, 2.0, 3.0)

  //从左算
  println(b.reduceLeft(divide))
  //从右算
  println(b.reduceRight(divide))

  //scanLeft and scanRight
  val product = (x: Int, y: Int) => {
    val result = x * y
    println(s"multiplied $x by $y to yield $result")
    result
  }
  val c = Array(1, 2, 3)
  c.scanLeft(10)(product).foreach(x=>print(x+" "))

  println()

  val findMax2 = (x: Int, y: Int) => {
    Thread.sleep(10)
    val winner = x max y
    println(s"compared $x to $y, $winner was larger")
    winner
  }
  val a2 = Array.range(0,50)
  a2.par.reduce(findMax2)

}
