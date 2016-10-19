package scalacookbook.chapter19

/**
  * +T 协变
  * -T 逆变
  *
  * Created by liguodong on 2016/8/22.
  */
object MakeImmutableCollectionsCovariant extends App{
  //Covariant type parameters are shown in the Scaladoc
  // for immutable collection classes like List, Vector, and Seq
  /*
  class List[+T]
  class Vector[+A]
  trait Seq[+A]
  */

  //define a makeDogsSpeak method, but instead of accepting a mutable ArrayBuffer[Dog]
  //as in the previous recipe, accept an immutable Seq[Dog]
  import section05._

  def makeDogsSpeak(dogs: Seq[Dog]) {
    dogs.foreach(_.speak)
  }

  //As with the ArrayBuffer in the previous recipe,
  // you can pass a sequence of type [Dog]
  // this works
  val dogs = Seq(new Dog("Fido"), new Dog("Tanner"))
  makeDogsSpeak(dogs)

  //However, in this case, you can also pass a Seq[SuperDog]
  //  into the makeDogsSpeak method successfully.

  // this works too
  val superDogs = Seq(new SuperDog("Wonder Dog"), new SuperDog("Scooby"))
  makeDogsSpeak(superDogs)


  //Because Seq is immutable and defined with a covariant parameter type,
  // makeDogsSpeak can now accept collections of both Dog and SuperDog.


  //Discussion
  println("=======================")

  def makeDogsSpeak(dogHouse: Container[Dog]) {
    dogHouse.elem.speak
  }

  // pass a Container[Dog] into makeDogsSpeak
  val dogHouse = new Container(new Dog("Tanner"))
  makeDogsSpeak(dogHouse)

  //Finally, to demonstrate the point of adding the + symbol to the parameter,
  // you can also pass a Container[SuperDog] into makeDogsSpeak.
  val superDogHouse = new Container(new SuperDog("Wonder Dog"))
  makeDogsSpeak(superDogHouse)

  //Because the Container element is immutable and its mutable
  // type parameter is marked as covariant,
  //all of this code works successfully. Note that if you change the
  //Container’s type parameter from +A to A,
  // the last line of code won’t comp

}


package section05{

  trait Animal {
    def speak
  }
  class Dog(var name: String) extends Animal {
    def speak { println("Dog says woof") }
  }
  class SuperDog(name: String) extends Dog(name) {
    override def speak { println("I'm a SuperDog") }
  }

  class Container[+A] (val elem: A)

}