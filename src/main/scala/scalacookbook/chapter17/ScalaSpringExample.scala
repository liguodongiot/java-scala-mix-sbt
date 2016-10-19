package scalacookbook.chapter17

import org.springframework.context.support.ClassPathXmlApplicationContext

/**
  * Created by liguodong on 2016/8/19.
  */

object ScalaSpringExample extends App {

  // open & read the application context file
  val ctx = new ClassPathXmlApplicationContext("scalacookbook/applicationContext.xml")

  // instantiate the dog and cat objects from the application context
  val dog = ctx.getBean("dog").asInstanceOf[Animal]

  val cat = ctx.getBean("cat").asInstanceOf[Animal]

  // let them speak
  dog.speak
  cat.speak
}

abstract class Animal(name: String) {
  def speak: Unit // asbtract
}

class Dog(name: String) extends Animal(name) {
  override def speak {
    println(name + " says Woof")
  }
}

class Cat(name: String) extends Animal(name) {
  override def speak {
    println(name + " says Meow")
  }
}