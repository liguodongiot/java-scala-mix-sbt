package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object FlatList extends App{

  val lol = List(List(1,2), List(3,4))

  val result = lol.flatten

  println(result)

  val a = Array(Array(1,2), Array(3,4))

  val resultA = a.flatten

  println(resultA.mkString("[",", ","]"))

  val couples = List(List("kim", "al"), List("julia", "terry"))

  val people = couples.flatten
  println(people)

  val people2 = couples.flatten.map(_.capitalize).sorted
  println(people2.mkString("[",", ","]"))

  val myFriends = List("Adam", "David", "Frank")
  val adamsFriends = List("Nick K", "Bill M")
  val davidsFriends = List("Becca G", "Kenny D", "Bill M")
  val friendsOfFriends = List(adamsFriends, davidsFriends)

  val uniqueFriendsOfFriends = friendsOfFriends.flatten.distinct

  println(uniqueFriendsOfFriends.mkString("[",", ","]"))


  val list = List("Hello", "world")

  val listflatten = list.flatten
  println(listflatten.mkString("[",", ","]"))

  val x = Vector(Some(1), None, Some(3), None)
  val listx = x.flatten
  println(listx)


}
