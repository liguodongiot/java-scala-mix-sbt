package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */

object ControlVisibilityConstructorFields extends App{

  class PersonVar(var name: String)

  //拥有set和get
  //////var fields//////
  val pr = new PersonVar("Alvin Alexander")

  // getter
  println(pr.name)

  // setter
  pr.name = "Fred Flintstone"

  println(pr.name)

  //只有get
  //////val fields//////
  class PersonVal(val name: String)

  val pl = new PersonVal("Alvin Alexander")
  pl.name
  //pl.name = "Fred Flintstone"

  //没有set和get
  ///////Fields without val or var///////
  class Person(name: String)
  val p = new Person("Alvin Alexander")
  //p.name

  ///////Adding private to val or var///////
  class PersonP(private var name: String) { def getName {println(name)} }

  val pp = new PersonP("Alvin Alexander")
  //pp.name

  pp.getName


  println("/////////////////////////")
  //Discussion

  //Case classes
  //case class 和 class 规则不同
  //case class 构造器参数默认是val
  //因此，如果定义了一个case class的属性不用增加val或var
  case class PersonCC(name: String)
  val pcc = PersonCC("Dale Cooper")
  println(pcc.name)

}



