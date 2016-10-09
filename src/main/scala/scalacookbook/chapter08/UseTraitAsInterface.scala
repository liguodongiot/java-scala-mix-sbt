package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object UseTraitAsInterface extends App{

  //The term “mixed in” is also used when extending a single object instance with a trait, like this:
  //val f = new Foo with Trait1

}



package section01{

  trait BaseSoundPlayer {
    def play
    def close
    def pause
    def stop
    def resume
  }

  //带参数
  trait Dog {
    def speak(whatToSay: String)
    def wagTail(enabled: Boolean)
  }

  // a class extends a trait
  class Mp3SoundPlayer extends BaseSoundPlayer {
    def play { // code here ...
    }
    def close { // code here ...
    }
    def pause { // code here ...
    }
    def stop { // code here ...
    }
    def resume {
      // code here ...
    }
  }

  class BaseClass

  //extending a class and one or more traits
  class Foo extends BaseClass with BaseSoundPlayer with Dog {
    override def play: Unit = {}
    override def close: Unit = {}
    override def pause: Unit = {}
    override def stop: Unit =  {}
    override def resume: Unit = {}

    override def speak(whatToSay: String): Unit =  {}
    override def wagTail(enabled: Boolean): Unit =  {}
  }

  //a class extends multiple traits, use extends for the first trait,
  // and with for subsequent traits
  class FooOnlyTrait extends Dog with BaseSoundPlayer{
    override def speak(whatToSay: String): Unit = {}
    override def wagTail(enabled: Boolean): Unit = {}

    override def play: Unit = {}
    override def close: Unit = {}
    override def pause: Unit = {}
    override def stop: Unit = {}
    override def resume: Unit = {}
  }


  //a class extends a trait but does not implement the abstract methods
  // defined in that trait, it must be declared abstract

  // must be declared abstract because it does not implement
  // all of the BaseSoundPlayer methods
  abstract class SimpleSoundPlayer extends BaseSoundPlayer {
    def play { }
    def close { }
  }



  class BasicPlayer
  class BasicController

  trait BaseSoundFilePlayer{
    def getBasicPlayer: BasicPlayer
    def getBasicController: BasicController
    def setOld(volume: Double)
  }

  //one trait can extend another trait
  trait Mp3BaseSoundFilePlayer extends BaseSoundFilePlayer {
    def getBasicPlayer: BasicPlayer
    def getBasicController: BasicController

    def setGain(volume: Double)
  }

  class SubClassPlayer extends Mp3BaseSoundFilePlayer{
    override def getBasicPlayer: BasicPlayer = {val b = new BasicPlayer;b}

    override def getBasicController: BasicController = {val b = new BasicController;b}

    override def setGain(volume: Double): Unit = {}

    override def setOld(volume: Double): Unit = {}
  }


  abstract class Animal {
    def speak
  }
  trait WaggingTail {
    def startTail { println("tail started") }
    def stopTail { println("tail stopped") }
  }
  trait FourLeggedAnimal {
    def walk
    def run
  }

  class PigDog extends Animal with WaggingTail with FourLeggedAnimal {
    // implementation code here ...
    def speak { println("Dog says 'woof'") }
    def walk { println("Dog is walking") }
    def run { println("Dog is running") }
  }



}







package cb008.section1{

}
