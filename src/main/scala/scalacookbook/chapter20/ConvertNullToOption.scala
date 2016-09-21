package scalacookbook.chapter20

/**
  * Created by liguodong on 2016/8/28.
  */
object ConvertNullToOption extends App{

  class Persion(private var _name: String){
    def getName = _name
    def this(){
      this(null)
      _name=null
    }

  }
  val javaPerson = new Persion
  val javaPerson2 = new Persion("liguodong")

  def getName: Option[String] = {
    var name = javaPerson.getName
    if (name == null) None else Some(name)
  }
  println(getName)

}
