package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object UseTraitAsInterface extends App{

}
package test6{

  trait BaseSoundPlayer {
    def play
    def close
    def pause
    def stop
    def resume
  }

  trait Dog {
    def speak(whatToSay: String)
    def wagTail(enabled: Boolean)
  }

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


  // must be declared abstract because it does not implement
  // all of the BaseSoundPlayer methods
  abstract class SimpleSoundPlayer extends BaseSoundPlayer {
    def play { }
    def close { }
  }


  //one trait can extend another trait
  class BasicPlayer
  class BasicController

  trait BaseSoundFilePlayer{
    def getBasicPlayer: BasicPlayer
    def getBasicController: BasicController
    def setOld(volume: Double)
  }

  trait Mp3BaseSoundFilePlayer extends BaseSoundFilePlayer {
    def getBasicPlayer: BasicPlayer

    def getBasicController: BasicController
    def setGain(volume: Double)
  }

}







package cb008.section1{
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
  class Dog extends Animal with WaggingTail with FourLeggedAnimal {
    // implementation code here ...
    def speak { println("Dog says 'woof'") }
    def walk { println("Dog is walking") }
    def run { println("Dog is running") }
  }

}
