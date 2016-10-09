package module.detailtrait

/**
  * 作为接口的trait
  * trait很强大，抽象类能做的事情，trait都可以做，它的长处在于可以多继承。
  * trait和抽象类的区别在于抽象类是对一个继承链的，类和类之前确实有父子类的继承关系，
  * 而trait则如其名字，表示一种特征，可以多继承。
  * Created by liguodong on 2016/10/9.
  */
object TraitAsInterface extends App {

  val fish = new FishEagle;
  fish.walk(100);
  fish.fly;
  fish.swim;
  println("fish eagle has father ? " + fish.hasFather + ".");
  // println(fish.swim);    // 输出为()

  println("--------------------");
  val flyable : Flyable = fish;
  flyable.fly;

  val swimable : Swimable = fish;
  swimable.swim;

}


abstract class Animal {
  def walk(speed : Int);

  def breathe () = {
    println("animal breathes.");
  }
}


/**
  * 有两个方法，一个抽象方法一个已实现方法
  */
trait Flyable {
  def hasFather = true;
  def fly;
}

/**
  * 只有一个抽象方法
  */
trait Swimable {
  def swim;
}

//定义一种动物，它既会飞也会游泳，这种动物是鱼鹰 FishEagle
class FishEagle extends Animal with Flyable with Swimable {
  /**
    * 实现抽象类的walk方法
    */
  override def walk(speed: Int) = {
    println ("Fish eagle walk with speed : " + speed + ".");
  }

  /**
    * 实现trait Flyable的方法
    */
  override def fly = {
    println("Fish eagle fly fast.");
  }

  /**
    * 实现trait Swimable的方法
    */
  override def swim {
    println("Fish eagle swim fast.");
  }
}
