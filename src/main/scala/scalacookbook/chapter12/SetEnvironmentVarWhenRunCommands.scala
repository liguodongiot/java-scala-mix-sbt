package scalacookbook.chapter12

import java.io.File
import scala.sys.process.Process

/**
  * 设置当前的环境变量
  * Created by liguodong on 2016/8/10.
  */
object SetEnvironmentVarWhenRunCommands extends App{

  //在/home/al/bin目录运行一个shell脚本，并且设置环境变量。
  val p = Process("runFoo.sh",
    new File("/Users/Al/bin"),
    "PATH" -> ".:/usr/bin:/opt/scala/bin")
  val output = p.!!


  //一次性实现多个环境变量
  val output2 = Process("env",
    None,
    "VAR1" -> "foo",
    "VAR2" -> "bar")


}
