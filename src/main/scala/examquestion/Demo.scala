package examquestion



/**
  * Created by liguodong on 2016/10/14.
  */
object Demo  {

  var times = 0;

  def asciiDisplay(
      root: TreeNode[String])
    : Unit = {

    var temp = times

    //var result = List[String]()

    //result = result :+ ("+="+root.data)
    println("+="+root.data)

    if(root.children!=Nil){
      times = times+1
    }

    for (temp <-root.children){
//      if(root.children == Nil){
//        result = result :+ ("| ")
//      }
      //result = result :+ ("  "+asciiDisplay(temp))
      if(times>=1){
        print("  ")
      }
      for(i <- 2 to times)
        print("| ")

      asciiDisplay(temp)
    }

    times = temp

    //result
  }








}

case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)