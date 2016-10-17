package scalacookbook.chapter09

/**
  * Created by liguodong on 2016/7/23.
  */
object DefineMethodAcceptFunctionParam extends App{

  //函数没有参数，也没有返回值。
  //  Two quick notes:
  //  • The callback:() syntax defines a function that has no parameters.
  // If the function had parameters, the types would be listed inside the parentheses.
  //  • The => Unit portion of the code indicates that this method returns nothing
  def executeFunction(callback:() => Unit) {
    callback()
  }


  val sayHello = () => { println("Hello") }
  executeFunction(sayHello)


  //Discussion
  // These days, just as I often name an Int parameter i,
  //I name a function parameter f.
  def executeFunction2(f:() => Unit) {
    f()
  }

  //The general syntax for defining a function as a method parameter.
  //parameterName: (parameterType(s)) => returnType


  //the parameterName is f, the parameterType is empty, the return type is Unit
  def executeFunction3(f:() => Unit){
    f()
  }

  //executeFunction(f:String => Int)
  //executeFunction(f:(String) => Int)

  //签名有有参数和返回值，执行函数无返回值
  def executeFunction4(f:String => Int){
    f("323")
  }

  //执行函数有返回值
  def executeFunction5(f:(String) => Int): Int ={
    f("323")
  }

  def strToInt(s:String): Int ={
    s.toInt
  }

  println(executeFunction4(strToInt))

  println(executeFunction5(strToInt))

  //Scala’s Unit

  def plusOne(i: Int) = i + 1
  println(plusOne(1))

  def plusOne2(i: Int): Unit = i + 1
  println(plusOne2(1))

}
