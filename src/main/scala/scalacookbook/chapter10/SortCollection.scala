package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/30.
  */
object SortCollection extends App{

  val a = List(10, 5, 8, 1, 7).sorted

  println(a)

  val b = List("banana", "pear", "apple", "orange").sorted

  println(b)

  //The sortWith method lets you provide your own sorting function.
  println(List(10, 5, 8, 1, 7).sortWith(_ < _))

  println(List(10, 5, 8, 1, 7).sortWith(_ > _))

  println(List("banana", "pear", "apple", "orange").sortWith(_ < _))

  println(List("banana", "pear", "apple", "orange").sortWith(_ > _))

  println(List("banana", "pear", "apple", "orange").sortWith(_.length < _.length))

  println( List("banana", "pear", "apple", "orange").sortWith(_.length > _.length))

  //sorting method gets longer, first declare it as a method.
  def sortByLength(s1: String, s2: String) = {
    println("comparing %s and %s".format(s1, s2))
    s1.length > s2.length
  }

  List("banana", "pear", "apple").sortWith(sortByLength)

  //Discussion
  class Person2 (var name: String) {
    override def toString = name
  }

  //create a List[Person]
  val ty = new Person2("Tyler")
  val al = new Person2("Al")
  val paul = new Person2("Paul")
  val dudes = List(ty, al, paul)


  //You can’t use sorted with the Person class as it’s written,
  // but you can write a simple anonymous function to sort the
  // Person elements by the name field using sortWith.

  // dudes.sorted  //error

  val sortedDudes = dudes.sortWith(_.name < _.name)

  val sortedDudes2 = dudes.sortWith(_.name > _.name)

  //Mix in the Ordered trait

  //use the Person class with the sorted method, just mix the Ordered trait
  //into the Person class, and implement a compare method.
  class Person (var name: String) extends Ordered [Person]
  {
    override def toString = name
    // return 0 if the same, negative if this < that, positive if this > that
    def compare (that: Person) = {
      if (this.name == that.name)
        0
      else if (this.name < that.name)
        -1
      else
        1
    }

    //Note that because this compare algorithm only compares two String values,
    // it could have been written like this.
    //def compare (that: Person) = this.name.compare(that.name)
  }


  val ty2 = new Person("Tyler")
  val al2 = new Person("Al")
  val paul2 = new Person("Paul")
  val dudes2 = List(ty2, al2, paul2)

  println(dudes2.sorted)

}



