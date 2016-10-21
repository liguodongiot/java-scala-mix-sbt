package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object AccessMapValue extends App{

  val states = Map("周杰伦" -> "昆凌", "习大大" -> "彭麻麻", "黄晓明" -> "杨颖")

  val az = states("习大大")
  println(az)

  //val s = states("FOO")
  //println(s)

  val states2 = Map("周杰伦" -> "昆凌").withDefaultValue("Not found")
  println(states2("林志玲"))

  println(states2("习大大"))

  println(states2("周杰伦"))


  val s2 = states.getOrElse("林志玲", "No such state")
  println(s2)

  val az2 = states.get("黄晓明")
  println(az2)

  val az3 = states.get("林志玲")
  println(az3)

}
