package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object MarkTraitBySubclasses extends App{

  import test4._
  val e = new Enterprise

}



package test3{

  trait StarfleetWarpCore {
    this: Starship =>
    // more code here ...
  }

  class Starship

  class Enterprise extends Starship with StarfleetWarpCore

  class RomulanShip

  // this won't compile
  //class Warbird extends RomulanShip with StarfleetWarpCore
}

package test4{

  trait WarpCore {
    this: Starship with WarpCoreEjector with FireExtinguisher =>
  }

  class Starship
  trait WarpCoreEjector
  trait FireExtinguisher

  // this works
  class Enterprise extends Starship
    with WarpCoreEjector
    with FireExtinguisher
    with WarpCore

  // if the Enterprise doesn’t extend Starship,
  // WarpCoreEjector, and FireExtinguisher, the code won’t compile.

}