package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/28.
 */



object AddIfExpressionToCase extends App{

  val i =1
  i match {
    case a if 0 to 9 contains a => println("0-9 range: " + a)
    case b if 10 to 19 contains b => println("10-19 range: " + b)
    case c if 20 to 29 contains c => println("20-29 range: " + c)
    case _ => println("Hmmm...")
  }

  val num = 1
  num match {
    case x if x == 1 => println("one, a lonely number")
    case x if (x == 2 || x == 3) => println(x)
    case _ => println("some other value")
  }

  class Stock(val symbol:String,val price:Int)
  val stock = new Stock("XYZ",10)
  stock match {
    case x if (x.symbol == "XYZ" && x.price < 20) => println("buy(x)")//buy(x)
    case x if (x.symbol == "XYZ" && x.price > 50) => println("sell(x)")//sell(x)
    case _ => // do nothing
  }

  case class Person(name:String)

  def speak(p: Person) = p match {
    case Person(name) if name == "Fred" => println("Yubba dubba doo")
    case Person(name) if name == "Bam Bam" => println("Bam bam!")
    case _ => println("Watch the Flintstones!")
  }
  speak(Person("Fred"))



  //Discussion
  /*
  case Person(name) =>
  if (name == "Fred") println("Yubba dubba doo")
  else if (name == "Bam Bam") println("Bam bam!")
  */

}

