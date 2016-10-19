package module.detailtrait

/**
  * Created by liguodong on 2016/10/9.
  */
object AOPScala extends App{
  /**
    * Scala中多重继承中方法的混入是由左往右的顺序。（见以下实例讲解）
    * scala中多继承对象方法的调用顺序是从右往左。（见以下实例讲解）
    */

  val work = new Worker with toBefo with toBefo2
  work.doAction

}

trait Action{
  println("-----Action-----")
  def doAction
}

trait toBefo extends Action{
  println("-----toBefo-----")
  abstract  override def doAction {
    println("toBefo function")
    super.doAction
    println("toBefo function over")
  }
}

trait toBefo2 extends Action /* with toBefo*/ {
  println("-----toBefo2-----")
  abstract override def doAction={
    println("toBefo2 function")
    super.doAction
    println("toBefo2 function over")
  }
}


class Worker extends Action{
  println("-----Worker-----")
  override def doAction=println("working .........")
}
