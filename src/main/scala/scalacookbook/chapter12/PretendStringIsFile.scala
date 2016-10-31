package scalacookbook.chapter12

import scala._

/**
  * Created by liguodong on 2016/8/5.
  */
object PretendStringIsFile extends App{

  import io.Source
  def printLines(source: Source) {
    for (line <- source.getLines) {
      println(line)
    }
  }

  val s = Source.fromString("foo\nbar\n")
  printLines(s)

  val f = Source.fromFile("D:\\lilili.txt")
  printLines(f)

  val k = Source.fromFile("D:\\lilili.txt")
  val list = FileUtils.getLinesUppercased(k)

  for(temp <- list){
    println(temp)
  }

  //When writing unit tests, you might have a method like this that you’d like to test.
  //单元测试
  //FileUtilTests

}


//单元测试
object FileUtils {
  def getLinesUppercased(source: io.Source): List[String] = {
    (for (line <- source.getLines) yield line.toUpperCase).toList
  }
}

//As shown in the following ScalaTest tests, you can test the getLinesUppercased
// method by passing it either a Source from a file or a String.


//import org.scalatest.{FunSuite, BeforeAndAfter}
//import scala.io.Source
//class FileUtilTests extends FunSuite with BeforeAndAfter {
//  var source: Source = _
//  after { source.close }
//  // assumes the file has the string "foo" as its first lin
//  test("1 - foo file") {
//    source = Source.fromFile("/Users/Al/tmp/foo")
//    val lines = FileUtils.getLinesUppercased(source)
//    assert(lines(0) == "FOO")
//  }
//
//  test("2 - foo string") {
//    source = Source.fromString("foo\n")
//    val lines = FileUtils.getLinesUppercased(source)
//    assert(lines(0) == "FOO")
//  }
//}