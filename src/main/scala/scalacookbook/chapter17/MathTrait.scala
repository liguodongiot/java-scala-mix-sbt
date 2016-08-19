package scalacookbook.chapter17

/**
  * You can’t use the implemented methods of a Scala trait from Java,
  * so wrap the trait in a class.
  *
  * Created by liguodong on 2016/8/19.
  */
// the original trait
trait MathTrait {
  def sum(x: Int, y: Int) = x + y
}
// the wrapper class
class MathTraitWrapper extends MathTrait