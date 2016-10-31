package scalacookbook.chapter12

import org.scalatest.{FunSuite, BeforeAndAfter}
import scala.io.Source

/**
  * Created by liguodong on 2016/10/31.
  */
class FileUtilTests extends FunSuite with BeforeAndAfter {
  var source: Source = _

  after { source.close }
  // assumes the file has the string "foo" as its first line
  test("1 - foo file") {
    source = Source.fromFile("D:\\foo.txt")
    val lines = FileUtils.getLinesUppercased(source)
    assert(lines(0) == "FOO")
  }

  test("2 - foo string") {
    source = Source.fromString("foo\n432")
    val lines2 = FileUtils.getLinesUppercased(source)
    assert(lines2(0) == "FOO")
  }
}
