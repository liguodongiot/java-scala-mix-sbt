package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/24.
  */
object SelectivelyAddNewBehaviorClosedModel extends App{
  //create an add method that accepts different numeric types
  def add[A](x: A, y: A)(implicit numeric: Numeric[A]): A = numeric.plus(x, y)

  //Once defined, this method can be used with different numeric types
  println(add(1, 1))
  println(add(1.0, 1.5))
  println(add(1, 1.5F))
  //If you attempted to pass a String into it, it won’t compile
  // won't compile
  //add("1", 2.0)



  //Creating a type class
  import section08._
  import section08.Humanish.HumanLike

  // create a method to make an animal speak
  def makeHumanLikeThingSpeak[A](animal: A)(implicit humanLike: HumanLike[A]) {
    humanLike.speak(animal)
  }
  // because HumanLike implemented this for a Dog, it will work
  makeHumanLikeThingSpeak(Dog("Rover"))
  // however, the method won't compile for a Cat (as desired)
  //makeHumanLikeThingSpeak(Cat("Morris"))

}


package section08{
  // an existing, closed model
  trait Animal
  final case class Dog(name: String) extends Animal
  final case class Cat(name: String) extends Animal

  object Humanish {
    // the type class.
    // defines an abstract method named 'speak'.
    trait HumanLike[A] {
      def speak(speaker: A): Unit
    }
    // companion object
    object HumanLike {
      // implement the behavior for each desired type. in this case,
      // only for a Dog.
      implicit object DogIsHumanLike extends HumanLike[Dog] {
        def speak(dog: Dog) { println(s"I'm a Dog, my name is ${dog.name}") }
      }
    }
  }

}