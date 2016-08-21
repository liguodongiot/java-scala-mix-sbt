package scalacookbook.chapter03

import java.io.{IOException, FileOutputStream, FileInputStream}

/**
 * Created by liguodong on 2016/6/28.
 */
object DeclareVariableBeforeUseBlock extends App{
  var in = None: Option[FileInputStream]
  var out = None: Option[FileOutputStream]

  try {
    in = Some(new FileInputStream("D:\\lilili.txt"))
    out = Some(new FileOutputStream("D:\\lilili.txt.copy"))
    var c = 0
    while ({c = in.get.read; c != -1} ) {
      out.get.write(c)
    }
  } catch {
    case e: IOException => e.printStackTrace
  } finally {
    println("entered finally ...")
    if (in.isDefined) in.get.close
    if (out.isDefined) out.get.close
  }


  try {
    in = Some(new FileInputStream("D:\\lilili.txt.copy"))
    out = Some(new FileOutputStream("D:\\lilili.txt.copy.copy"))
    in.foreach { inputStream =>
      out.foreach { outputStream =>
        var c = 0
        while ({c = inputStream.read; c != -1}) {
          outputStream.write(c)
        }
      }
    }
  } catch {
    case e: IOException => e.printStackTrace
  } finally {
    println("entered finally ...")
    if (in.isDefined) in.get.close
    if (out.isDefined) out.get.close
  }



}
