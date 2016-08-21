package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object EnsureTraitAddedType {

}

package test5{

  trait WarpCore {
    this: { def ejectWarpCore(password: String): Boolean } =>
  }

  class Starship {
    // code here ...
  }
  class Enterprise extends Starship with WarpCore {
    def ejectWarpCore(password: String): Boolean = {
      if (password == "password") {
        println("ejecting core")
        true
      } else {
        false
      }
    }
  }


}


package test6{
  trait WarpCore {
    this: {
      def ejectWarpCore(password: String): Boolean
      def startWarpCore: Unit
    } =>
  }
  class Starship

  class Enterprise extends Starship with WarpCore {
    def ejectWarpCore(password: String): Boolean = {
      if (password == "password") { println("core ejected"); true } else false
    }

    def startWarpCore { println("core started") }
  }
}
