package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */

object DefinePrivatePrimaryConstructor extends App{

  import section04._

  //让类的主构造器私有，例如单例模式。
  class PersonPri private (name: String)

  //Error:constructor PersonPri in class PersonPri cannot be accessed
  // in object DefinePrivatePrimaryConstructor

  //val p = new PersonPri("Mercedes")

  //Discussion
  //A simple way to enforce the Singleton pattern in Scala

  // this won't compile
  // val brain = new Brain

  // this works
  val brain = Brain.getInstance
  println(brain)


  //Utility classes（实用工具类）
  val contents = FileUtils.readFile("input.txt")

  FileUtils.writeToFile("output.txt", "liguodong")

  //val utils = new FileUtils // won't compile
}

package section04{

  class Brain private {
    override def toString = "This is the brain."
  }

  object Brain {
    //增加一个getInstance方法在伴生对象中
    val brain = new Brain
    def getInstance = brain
  }

  object FileUtils {
    def readFile(filename: String) = {
      // code here ...
    }
    def writeToFile(filename: String, contents: String) {
      // code here ...
    }
  }
}

