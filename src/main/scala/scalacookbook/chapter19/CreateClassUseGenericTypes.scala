package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/22.
  */
object CreateClassUseGenericTypes extends App{

  val ints = new LinkedList[Int]()
  ints.add(1)
  ints.add(2)
  ints.printAll()


  val strings = new LinkedList[String]()
  strings.add("Nacho")
  strings.add("Libre")
  strings.printAll()

  //other type
  val doubles = new LinkedList[Double]()
  val frogs = new LinkedList[Frog]()

  //Discussion
  import section01._
  val dogs = new LinkedList[Dog]
  val fido = new Dog
  val wonderDog = new SuperDog
  val scooby = new FunnyDog

  dogs.add(fido)
  dogs.add(wonderDog)
  dogs.add(scooby)

  dogs.printAll()

  println("=================")

  def printDogTypes(dogs: LinkedList[Dog]) {
    dogs.printAll()
  }
  printDogTypes(dogs)
  println("=================")

  val superDogs = new LinkedList[SuperDog]
  superDogs.add(wonderDog)

  // error: this line won't compile
  //printDogTypes(superDogs)


  //Type parameter symbols
  //If a class requires more than one type parameter

  //Java
  /*
  public interface Pair<K, V> {
    public K getKey();
    public V getValue();
  }
  */

  //Scala
  trait Pair[A, B] {
    def getKey: A
    def getValue: B
  }


}

class Frog

class LinkedList[A] {
  private class Node[A] (elem: A) {
    var next: Node[A] = _
    override def toString = elem.toString
  }

  private var head: Node[A] = _
  def add(elem: A) {
    val n = new Node(elem)
    n.next = head
    head = n
  }

  private def printNodes(n: Node[A]) {
    if (n != null) {
      println(n)
      printNodes(n.next)
    }
  }

  def printAll() { printNodes(head) }
}

package section01{
  trait Animal
  class Dog extends Animal { override def toString = "Dog" }

  class SuperDog extends Dog { override def toString = "SuperDog" }
  class FunnyDog extends Dog { override def toString = "FunnyDog" }

}

