package module.detailtrait

/**
  * 特质的构造顺序
  * Created by liguodong on 2016/10/9.
  */
object TraitOrder extends App{

  /**
    * 特质的构造是有顺序的，从左到右被构造，构造顺序为：
    * 超类、父特质、第一个特质、第二个特质（父特质不重复构造）、类
    */

  var p = new PianoPlayingTeacher
  println("---------------")
  p.teach
  p.playPiano
}

class Teacher {  // 实验用的空类
  println("===============I'm Teacher.");
}

trait TTeacher extends Teacher {
  println("===============I'm TTeacher.")
  def teach;    // 虚方法，没有实现
}

trait TPianoTeacher extends Teacher {
  println("===============I'm TPianoTeacher.")
  def playPiano = {                // 实方法，已实现
    println("I'm playing piano.");
  }
}

trait TMathTeacher extends Teacher {
  println("===============I'm TMathTeacher.")
}


class PianoPlayingTeacher extends Teacher with TTeacher with TPianoTeacher with TMathTeacher{
  println("===============I'm PianoPlayingTeacher.")
  def teach = {                   // 定义虚方法的实现
    println("I'm teaching students.");
  }
}
