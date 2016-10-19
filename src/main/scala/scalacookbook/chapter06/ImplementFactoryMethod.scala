package cb006

/**
  * Created by liguodong on 2016/7/10.
  */
object ImplementFactoryMethod extends App{

  import part9._
  //通过apply方法作为工厂接口
  val cat = Animal("cat") // creates a Cat
  val dog = Animal("dog") // creates a Dog

  cat.speak
  dog.speak

  //Discussion

  //If you don’t like using the apply method as the factory interface,
  //you can create the usual “get” method in the companion object
  val cat2 = Animal.getAnimal("cat") // returns a Cat
  val dog2 = Animal.getAnimal("dog") // returns a Dog

}

package part9{

  trait Animal {
    def speak
  }
  object Animal {
    private class Dog extends Animal {
      override def speak { println("woof") }
    }

    private class Cat extends Animal {
      override def speak { println("meow") }
    }

    // the factory method
    def apply(s: String): Animal = {
      if (s == "dog") new Dog
      else new Cat
    }

    // an alternative factory method (use one or the other)
    def getAnimal(s: String): Animal = {
      if (s == "dog") return new Dog
      else return new Cat
    }

  }
}
