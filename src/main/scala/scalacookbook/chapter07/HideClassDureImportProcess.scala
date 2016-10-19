package scalacookbook.chapter07

/**
  * Created by liguodong on 2016/7/17.
  */
object HideClassDureImportProcess extends App{

  //隐藏包中的某个类
  import java.util.{Random => _, _}
  // can't access Random
  //val r = new Random

  // can access other members
  new ArrayList

  //Note that the _ import wildcard must be in the last position.

  //隐藏多个类
  //hide multiple members during the import process
  import java.util.{List => _, Map => _, Set => _, _}
  new ArrayList

}
