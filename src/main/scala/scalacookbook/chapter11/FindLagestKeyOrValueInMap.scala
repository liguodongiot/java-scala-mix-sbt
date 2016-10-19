package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object FindLagestKeyOrValueInMap extends App{

  val grades = Map("Al" -> 80, "Kim" -> 95, "Teri" -> 85, "Julia" -> 90)

  println(grades.max)

  //key最大值
  println(grades.keysIterator.max)

  println(grades.keysIterator.reduceLeft((x,y) => if (x > y) x else y))

  println(grades.keysIterator.reduceLeft((x,y) => if (x.length > y.length) x else y))

  //value最大值
  println(grades.valuesIterator.max)

  println(grades.valuesIterator.reduceLeft(_ max _))

  println(grades.valuesIterator.reduceLeft((x,y) => if (x > y) x else y))


}
