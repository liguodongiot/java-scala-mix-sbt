package module.detailtrait

/**
  * Created by liguodong on 2016/10/9.
  */

object Main extends App{

  //在特质定义中混入特质
  trait reseting extends reset {
  }

  //在对象构造时混入特质
  class month{}
  val file = new month with reseting
  println(file.reset(5,14))


}


trait reset {
  def reset (m : Int, n : Int) :Int = if (m >= n) 1 else 2;
}

//一旦特质被定义了，就可以混入到类中
class Week extends reset {
}

trait B
trait C
//混入多个特质
class MulWeek extends reset with B with C {
}




