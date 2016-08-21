package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/7/3.
 */
object GenerateBoilerplateCode extends App{

  // name and relation are 'val' by default
  case class Person(name: String, relation: String)


  //apply
  //Accessor Mutator
  //toString
  //unapply
  //equals hashCode
  //copy


  // "new" not needed before Person
  val emily = Person("Emily", "niece")

  println(emily.name)

  case class Company (var name: String)
  val c = Company("Mat-Su Valley Programming")
  println(c.name)

  c.name = "Valley Programming"
  println(c.name)

  println(emily)

  //an unapply method is automatically created for a case class, it works well when
  //you need to extract information in match expressions
  emily match { case Person(n, r) => println(n, r)}

  //Case classes also have generated equals and hashCode methods,
  //so instances can be compared.
  val hannah = Person("Hannah", "niece")
  println(emily == hannah)


  //A case class even creates a copy method that is helpful when you need to clone an object,
  //and change some of the fields during the process
  case class Employee(name: String, loc: String, role: String)


  val fred = Employee("Fred", "Anchorage", "Salesman")
  println(fred)

  val joe = fred.copy(name="Joe", role="Mechanic")
  println(joe)


  //Discussion


}
