package scalacookbook.chapter04

/**
 * Created by liguodong on 2016/6/30.
 */
object AssignFieldBlockFunction extends App{

  val f = new Foo


}

class Foo {
  // set 'text' equal to the result of the block of code
  val text = {
    var lines = ""
    try {
      lines = io.Source.fromFile("D:\\lilili.txt").getLines.mkString
    } catch {
      case e: Exception => lines = "Error happened"
    }
    lines
  }

  println(text)

  //Discussion
  val fDis = new FooDis
}

class FooXML {

  import scala.xml.XML
  // assign the xml field to the result of the load method
  val xml = XML.load("http://example.com/foo.xml")
  // more code here ...
}

//ignore the potential for errors and shorten the class to this
class FooDis {
  val text =
    io.Source.fromFile("D:\\lilili.txt").getLines.foreach(println)
}