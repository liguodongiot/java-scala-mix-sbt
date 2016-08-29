package scalacookbook.chapter01

import org.scalatest.FunSuite
/**
  * Created by liguodong on 2016/8/22.
  */

class AccessCharFromStringTests extends FunSuite {
  test("test charAt method") {
    assert("hello".charAt(0) == 'h')
  }


  test("test apply method") {
    assert("hello".apply(1) == 'e')

  }

}
