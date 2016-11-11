package scalacookbook.chapter13

import akka.actor._

/**
  * 想让Actor在不同的时间切换状态
  * Created by liguodong on 2016/8/14.
  */
object SwitchBetweenDifferentState extends App{
  import scalacookbook.chapter13.section11._

  val system = ActorSystem("BecomeHulkExample")
  val davidBanner = system.actorOf(Props[DavidBanner], name = "DavidBanner")

  davidBanner ! ActNormalMessage // init to normalState
  davidBanner ! TryToFindSolution
  davidBanner ! BadGuysMakeMeAngry
  Thread.sleep(1000)

  davidBanner ! ActNormalMessage
  system.shutdown

}

package section11{
  case object ActNormalMessage
  case object TryToFindSolution
  case object BadGuysMakeMeAngry

  class DavidBanner extends Actor {

    import context._

    def angryState: Receive = {
      case ActNormalMessage =>
        println("Phew, I'm back to being David.")
        become(normalState)
    }

    def normalState: Receive = {
      case TryToFindSolution =>
        println("Looking for solution to my problem ...")
      case BadGuysMakeMeAngry =>
        println("I'm getting angry...")
        become(angryState)
    }

    def receive = {
      case BadGuysMakeMeAngry => become(angryState)
      case ActNormalMessage => become(normalState)
    }
  }
}

