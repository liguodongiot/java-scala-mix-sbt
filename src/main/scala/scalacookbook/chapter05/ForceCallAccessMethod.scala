package scalacookbook.chapter05

/**
 * Created by liguodong on 2016/7/4.
 */
object ForceCallAccessMethod extends App{


  val p = new Pizza

  // this fails because of the parentheses
  //p.crustSize()

  // this works
  p.crustSize

  //Discussion


}

class Pizza {
    // no parentheses after crustSize
    def crustSize = 12
  }
