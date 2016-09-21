package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/22.
  */
object CreateMethodSimpleGenericType extends App{

  // create a method without using generics
  def randomName(names: Seq[String]): String = {
    val randomNum = util.Random.nextInt(names.length)
    names(randomNum)
  }

  val names = Seq("Aleka", "Christina", "Tyler", "Molly")
  val winner = randomName(names)
  println(winner)


  //modify the method to use a generic type parameter
  def randomElement[A](seq: Seq[A]): A = {
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)
  }

  //the method can now be called on a variety of types
  println("String : "+randomElement(Seq("Aleka", "Christina", "Tyler", "Molly")))
  println("Int : "+randomElement(List(1,2,3)))
  println("Double : "+randomElement(List(1.0,2.0,3.0)))
  println("Char : "+randomElement(Vector.range('a', 'z')))

  //Note that specifying the method’s return type isn’t necessary,
  // so you can simplify the signature slightly, if desired:


  // change the return type from ':A =' to just '='
  def randomElement2[A](seq: Seq[A]) = {
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)
  }
  println("randomElement2 --> String : "+randomElement(Seq("Spark", "Kafka", "Flink", "Kylin")))


}
