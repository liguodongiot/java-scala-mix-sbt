package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object UseClosures extends App{

  var hello = "Hello"
  def sayHello(name: String) { println(s"$hello, $name") }

  // execute sayHello from the exec method foo
  val foo = new Foo
  foo.exec(sayHello, "Al")

  // change the local variable 'hello', then execute sayHello from
  // the exec method of foo, and see what happens
  hello = "Hola"
  foo.exec(sayHello, "Lorenzo")

  //Discussion
  println("-------------")

  //A second example
  val isOfVotingAge2 = (age: Int) => age >= 18
  isOfVotingAge2(16) // false
  isOfVotingAge2(20) // true

  var votingAge = 18
  val isOfVotingAge = (age: Int) => age >= votingAge
  def printResult(f: Int => Boolean, x: Int) {
    println(f(x))
  }
  printResult(isOfVotingAge, 20) // true


  // change votingAge in one scope
  votingAge = 21
  // the change to votingAge affects the result
  printResult(isOfVotingAge, 20) // now false


  //Using closures with other data types
  import scala.collection.mutable.ArrayBuffer
  val fruits = ArrayBuffer("apple")

  // the function addToBasket has a reference to fruits
  val addToBasket = (s: String) => {
    fruits += s
    println(fruits.mkString(", "))
  }

  def buyStuff(f: String => Unit, s: String) {
    f(s)
  }

  buyStuff(addToBasket, "cherries")
  buyStuff(addToBasket, "grapes")

}

class Foo {
  // a method that takes a function and a string, and
  // the function, and then executes the function
  def exec(f:(String) => Unit, name: String) {
    f(name)
  }
}