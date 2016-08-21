package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */
object ControlVisibilityConstructorFields extends App{
  class PersonVar(var name: String)

  //////var fields//////
  val pr = new PersonVar("Alvin Alexander")

  // getter
  pr.name

  // setter
  pr.name = "Fred Flintstone"

  pr.name

  //////val fields//////
  class PersonVal(val name: String)

  val pl = new PersonVal("Alvin Alexander")
  pl.name
  //pl.name = "Fred Flintstone"

  ///////Fields without val or var///////
  class Person(name: String)
  val p = new Person("Alvin Alexander")
  //p.name

  ///////Adding private to val or var///////
  class PersonP(private var name: String) { def getName {println(name)} }

  val pp = new PersonP("Alvin Alexander")
  //pp.name

  pp.getName



  //Discussion

  //Case classes
  //case class 和 class 规则不同
  //Case class constructor parameters are val by default.
  //So if you define a case class field without adding val or var
  case class PersonCC(name: String)
  val pcc = PersonCC("Dale Cooper")
  pcc.name

}



