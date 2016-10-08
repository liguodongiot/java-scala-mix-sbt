package cb006

/**
  * Created by liguodong on 2016/7/9.
  */
object DeterminingClassOfObject extends App{

  def printAll(numbers: Int*) {
    println("class: " + numbers.getClass)
  }

  printAll(1, 2, 3)
  printAll()


  //the <p> tag contains one child element
  val hello = <p>Hello, world</p>

  hello.child.foreach(println)
  hello.child.foreach(e => println(e.getClass))

  println("~~~~~~~~~~~")

  val hello2 = <p>Hello, <br/>world</p>
  hello2.child.foreach(e => println(e.getClass))

  println("-----Discussion-----")

  def printClass(c: Any) { println(c.getClass) }

  printClass(1)

  printClass("yo")

  println("===========")

  def printAll2(numbers: Int*) {
    numbers.foreach(println)
  }
  printAll2(1,2,3)
  printAll2()

}
