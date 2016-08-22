package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/22.
  */
class Grandparent
class Parent extends Grandparent
class Child extends Parent

//[A]: 从类型声明到实例化或使用类型实例时，只允许同一类型，不能变化
//[+A]: 从类型声明到实例化或使用类型实例时，允许类型向上转型，即声明的是子类，使用时可以接受或允许父类实例！
//[-A]: 从类型声明到实例化或使用类型实例时，允许类型向下转型，即声明的是父类，使用时可以接受或允许子类实例！
class InvariantClass[A]
class CovariantClass[+A]
class ContravariantClass[-A]

class VarianceExamples {
  def invarMethod(x: InvariantClass[Parent]) {}

  def covarMethod(x: CovariantClass[Parent]) {}
  def contraMethod(x: ContravariantClass[Parent]) {}

  //invarMethod(new InvariantClass[Child]) // ERROR - won't compile
  invarMethod(new InvariantClass[Parent]) // success
  //invarMethod(new InvariantClass[Grandparent]) // ERROR - won't compile

  covarMethod(new CovariantClass[Child]) // success
  covarMethod(new CovariantClass[Parent]) // success
  //covarMethod(new CovariantClass[Grandparent]) // ERROR - won't compile


  //contraMethod(new ContravariantClass[Child]) // ERROR - won't compile
  contraMethod(new ContravariantClass[Parent]) // success
  contraMethod(new ContravariantClass[Grandparent]) // success
}