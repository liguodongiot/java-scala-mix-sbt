package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/24.
  */
object CreatFunctionReturnFunction extends App{

  def saySomething(prefix: String) = (s: String) => {
    prefix + " " + s
  }
  //返回一个函数
  val sayHello = saySomething("Hello")

  println(sayHello("Al"))

  //Discussion

  //Another example
  def greeting(language: String) = (name: String) => {
    language match {
      case "english" => println("Hello, " + name)
      case "spanish" => println("Buenos dias, " + name)
    }
  }
  //返回一个函数
  val hello = greeting("english")

  //返回一个函数
  val buenosDias = greeting("spanish")

  hello("Al")
  buenosDias("Lorenzo")

  println("~~~~~~~~~~~~~~~~~~~~")

  //如果不清楚greeting2返回一个函数，可以让代码更加明确。
  //调用其他函数
  def greeting2(language: String) = (name: String) => {
    val english = () => "Hello, " + name
    val spanish = () => "Buenos dias, " + name
    language match {
      case "english" => println("returning 'english' function")
        println(english())
      case "spanish" => println("returning 'spanish' function")
        println(spanish())
    }
  }

  //返回一个函数
  val hello2 = greeting2("english")
  //返回一个函数
  val buenosDias2 = greeting2("spanish")

  hello2("Al")
  buenosDias2("Lorenzo")

}
