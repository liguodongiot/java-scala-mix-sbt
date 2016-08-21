package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object Main extends App{

  val list = List.range(1, 10)
  val events = list.filter(_ % 2 == 0)


  for {
    e <- list
    if e % 2 == 0
  } yield e
}
