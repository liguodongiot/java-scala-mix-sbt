package scalacookbook.chapter07

/**
  * Created by liguodong on 2016/7/17.
  */
object RenameMembersOnImport extends App{

  import java.util.{ArrayList => JavaArrayList}
  val list = new JavaArrayList[String]

  // rename multiple classes
  import java.util.{Date => JDate, HashMap => JHashMap}

  //Discussion

  //rename all classes that might be conflicting or confusing
  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.{Map => ScalaMutableMap}

  //just rename one class to clarify the situation
  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.Map

  import System.out.{println => p}
  p("hello")

}
