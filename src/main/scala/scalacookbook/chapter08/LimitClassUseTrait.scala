package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object LimitClassUseTrait {

}

package test1{
  //trait [TraitName] extends [SuperThing]
  class StarfleetComponent
  trait StarfleetWarpCore extends StarfleetComponent
  class Starship extends StarfleetComponent with StarfleetWarpCore
}

package test2{
  class StarfleetComponent
  trait StarfleetWarpCore extends StarfleetComponent
  class RomulanStuff

  // won't compile, because Warbird and StarfleetWarpCore don’t share the same superclass
  // class Warbird extends RomulanStuff with StarfleetWarpCore
}


abstract class Employee
class CorporateEmployee extends Employee
class StoreEmployee extends Employee

trait DeliversFood extends StoreEmployee

// this is allowed,Because the DeliversFood trait
// can only be mixed into classes that extend StoreEmployee.
class DeliveryPerson extends StoreEmployee with DeliversFood



//the following line of code won’t compile.
//class Receptionist extends CorporateEmployee with DeliversFood
