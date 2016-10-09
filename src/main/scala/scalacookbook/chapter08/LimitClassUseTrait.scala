package cb008

/**
  * Created by liguodong on 2016/7/21.
  */
object LimitClassUseTrait extends App{

  import section05._

  val d = new DeliveryPerson

  val r = new Receptionist

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

  //Warbird和StarfleetWarpCore不共享同样的父类
  // won't compile, because Warbird and StarfleetWarpCore don’t share the same superclass
  // class Warbird extends RomulanStuff with StarfleetWarpCore
}

package section05{

  abstract class Employee
  class CorporateEmployee extends Employee

  class StoreEmployee extends Employee

  trait DeliversFood extends StoreEmployee

  //DeliveryPerson和DeliversFood共享同样的父类
  // this is allowed,Because the DeliversFood trait
  // can only be mixed into classes that extend StoreEmployee.
  class DeliveryPerson extends StoreEmployee with DeliversFood

  //the following line of code won’t compile.
  //class Receptionist extends CorporateEmployee with DeliversFood

  //修改为如下方式
  trait DeliversFood2 extends CorporateEmployee
  class Receptionist extends CorporateEmployee with DeliversFood2

}

