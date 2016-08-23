package scalacookbook.chapter19

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liguodong on 2016/8/22.
  */
object MakeMutableCollectionsInvariant extends App{

  import section04._
  // create a Dog and a SuperDog
  val fido = new Dog("Fido")
  val wonderDog = new SuperDog("Wonder Dog")
  val shaggy = new SuperDog("Shaggy")

  //declare an ArrayBuffer[Dog], you can add both Dog and SuperDog instances
  val dogs = ArrayBuffer[Dog]()
  dogs += fido
  dogs += wonderDog

  //define a method as follows to accept an ArrayBuffer[Dog],
  // and then have each Dog speak
  import collection.mutable.ArrayBuffer
  def makeDogsSpeak(dogs: ArrayBuffer[Dog]) {
    dogs.foreach(_.speak)
  }

  makeDogsSpeak(dogs)

  //However, the makeDogsSpeak call won’t compile
  // if you attempt to pass it an ArrayBuffer[SuperDog]
  val superDogs = ArrayBuffer[SuperDog]()
  superDogs += shaggy
  superDogs += wonderDog
  //makeDogsSpeak(superDogs) // ERROR: won't compile




}


package section04{

  trait Animal {
    def speak
  }

  class Dog(var name: String) extends Animal {
    def speak { println("woof") }
    override def toString = name
  }
  class SuperDog(name: String) extends Dog(name) {
    def useSuperPower { println("Using my superpower!") }
  }
}