package examquestion

import org.scalatest.FunSuite

/**
  * Created by liguodong on 2016/10/15.
  */
class DemoTests extends FunSuite {

  test("test asciiDisplay method.") {
    Demo.asciiDisplay(
      TreeNode("Root",
        children = List(
          TreeNode("level1-1"),
          TreeNode("level1-2"),
          TreeNode("level1-3")
        )
      )
    )

    Demo.asciiDisplay(
      TreeNode("Root",
        children = List(
          TreeNode("level1-1",
            children =
              TreeNode("level2-1",
                children =
                  TreeNode("level3-1") :: Nil) :: Nil),
          TreeNode("level1-2"),
          TreeNode("level1-3")
        )
      )
    )
  }

}
