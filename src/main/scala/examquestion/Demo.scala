package examquestion



/**
  * Created by liguodong on 2016/10/14.
  */
object Demo extends App {

  def asciiDisplay(root: TreeNode[String]): Seq[String] = {
    var result = Seq[String]()

    result = result :+ ("+-"+root.data)

    for (temp <-root.children){
      result = asciiDisplay(temp)
    }

    result
  }


  asciiDisplay(TreeNode("Root",
    children = List(TreeNode("level1-1"),
      TreeNode("level1-2"),
      TreeNode("level1-3")))).foreach(println)

  asciiDisplay(TreeNode("Root",
    children = List(
      TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
      TreeNode("level1-2"),
      TreeNode("level1-3")))).foreach(println)
}

case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)