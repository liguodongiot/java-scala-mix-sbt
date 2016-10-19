package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object DeclareTypeWhenCreateCollection extends App{

  val x = List(1, 2.0, 33D, 400L)
  println(x)

  val x2 = List[Number](1, 2.0, 33D, 400L)
  println(x2)

  val x3 = List[AnyVal](1, 2.0, 33D, 400L)
  println(x3)

  //Discussion
  val xx = Array(Dog("Fido"), Cat("Felix"))

  val xx2 = Array[Animal](Dog("Fido"), Cat("Felix"))



}

trait Animal
trait FurryAnimal extends Animal

case class Dog(name: String) extends Animal
case class Cat(name: String) extends Animal

class AnimalKingdom {
  def animals = Array(Dog("Fido"), Cat("Felix"))

 // def animals2: Array[Product with Serializable with Animal]

  //def animals3: Array[Animal]

  def animals2 = Array[Animal](Dog("Fido"), Cat("Felix"))
}