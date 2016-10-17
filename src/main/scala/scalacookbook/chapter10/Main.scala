package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object Main extends App{

  val list = List.range(1, 10)
  println(list)

  val events = list.filter(_ % 2 == 0)
  println(events)

  for {
    e <- list
    if e % 2 == 0
  } yield print(e)


}
