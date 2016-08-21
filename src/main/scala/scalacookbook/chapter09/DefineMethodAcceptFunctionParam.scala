package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object DefineMethodAcceptFunctionParam extends App{

  def executeFunction(callback:() => Unit) {
    callback()
  }

  val sayHello = () => { println("Hello") }

  executeFunction(sayHello)

  //Discussion
  def executeFunction2(f:() => Unit) {
    f()
  }

  //The general syntax for defining a function as a method parameter.
  //parameterName: (parameterType(s)) => returnType


  //the parameterName is f, the parameterType is empty, the return type is Unit
  def executeFunction3(f:() => Unit){
    f()
  }


  def executeFunction4(f:String => Int){
    f("323")
  }
  def executeFunction5(f:(String) => Int): Int ={
    f("323")
  }


  def strToInt(s:String): Int ={
    s.toInt
  }

  println(executeFunction5(strToInt))

  def plusOne(i: Int) = i + 1

  plusOne(1)

  def plusOne2(i: Int): Unit = i + 1

  plusOne2(1)


}
