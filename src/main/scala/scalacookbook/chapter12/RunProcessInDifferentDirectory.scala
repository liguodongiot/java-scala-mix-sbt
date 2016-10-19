package scalacookbook.chapter12

import sys.process._
import java.io.File

/**
  * Created by liguodong on 2016/8/10.
  */
object RunProcessInDifferentDirectory extends App{


  //use another directory as the base directory when running an external command.
  val output = Process("ls -al", new File("G:\\github")).!!
  println(output)

  //current directory
  val p = Process("ls -al").!!
  println(p)
}
