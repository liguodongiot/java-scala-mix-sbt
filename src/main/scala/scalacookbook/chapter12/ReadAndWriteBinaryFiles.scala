package scalacookbook.chapter12

import java.io.{FileInputStream, FileOutputStream, IOException}

/**
  * Created by liguodong on 2016/8/4.
  */
object ReadAndWriteBinaryFiles extends App{

  var in = None: Option[FileInputStream]
  var out = None: Option[FileOutputStream]
  //字节流
  try {

    in = Some(new FileInputStream("D:\\HowOpenReadTextFile.class"))
    out = Some(new FileOutputStream("D:\\HowOpenReadTextFile.class.copy"))

    var c = 0
    while ({c = in.get.read; c != -1}) {
      out.get.write(c)
    }

  } catch {
    case e: IOException => e.printStackTrace
  } finally {

    println("entered finally ...")
    if (in.isDefined) in.get.close
    if (out.isDefined) out.get.close

  }

}
