package scalacookbook.chapter07

/**
  * Created by liguodong on 2016/7/17.
  */
object UseImportStatementsAnywhere extends App{

  import section06._
  val p = new ImportTests
  println(p.printRandom)
  println(p.getRandomWaitTimeInMinutes)
}


package section06{
  //类外面导入
  import scala.util.Random

  class ImportTests {
    //import members inside a class
    import scala.util.Random
    def printRandom : Int =  {
      val r = new Random
      val result = r.nextInt(10)
      result
    }

    def getRandomWaitTimeInMinutes: Int = {
      //limit the scope of an import to a method
      import java.util.ArrayList
      val p = new ArrayList[String]
      p.add("大王")
      p.add("东哥")
      p.size()
    }
  }
}

package foo{
  // available to all classes defined below   对包内和子包内都可见
  import java.io.File
  import java.io.PrintWriter
  class Foo {
    // only available inside this class
    import javax.swing.JFrame
    // ...
  }
  class Bar {
    // only available inside this class
    import scala.util.Random
    // ...
  }

  package database {
    // more code here ...
  }

}

