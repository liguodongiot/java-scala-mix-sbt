package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object UnderstandMutableVariables extends App{

  var sisters = Vector("Melinda")
  sisters = sisters :+ "Melissa"
  sisters = sisters :+ "Marisa"

  sisters.foreach(println)

  //以上的操作实际上是每一步操作分配了一个新的集合
  //  var sisters2 = Vector("Melinda")
  //  sisters2 = Vector("Melinda", "Melissa")
  //  sisters2 = Vector("Melinda", "Melissa", "Marisa")

}
