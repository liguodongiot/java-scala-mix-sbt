package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/8/1.
  */
object UseSortSet extends App{

  //A SortedSet returns elements in a sorted order
  val s = scala.collection.SortedSet(10, 4, 8, 2)
  println(s)

  val s2 = scala.collection.SortedSet("cherry", "kiwi", "apple")
  println(s2)

  //A LinkedHashSet saves elements in the order in which they were inserted:
  var s3 = scala.collection.mutable.LinkedHashSet(10, 4, 8, 2)
  println(s3)

  //Discussion

  //class Person (var name: String)
  //继承Ordered特质，并实现compare方法
  class Person (var name: String) extends Ordered [Person] {
    override def toString = name

    // return 0 if the same, negative if this < that, positive if this > that
    def compare(that: Person) = {
      if (this.name == that.name)
        0
      else if (this.name > that.name)
        1
      else
        -1
    }
  }
  import scala.collection.SortedSet
  val aleka = new Person("Aleka")
  val christina = new Person("Christina")
  val molly = new Person("Molly")
  val tyler = new Person("Tyler")

  // this won't work
  //val ss = SortedSet(molly, tyler, christina, aleka)


  //To solve this problem, modify the Person class to extend the Ordered trait,
  // and implement a compare method
  val ss = SortedSet(molly, tyler, christina, aleka) //scala.collection.SortedSet[Person] = TreeSet(Aleka, Christina, Molly, Tyler)




}
