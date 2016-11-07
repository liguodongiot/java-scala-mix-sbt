package scalacookbook.chapter12

/**
  * Created by liguodong on 2016/8/9.
  */
object HandleStdoutAndStderrExternalCommands {

  /*
    #!/bin/sh
    exec scala "$0" "$@"
    !#
    import sys.process._
    val stdout = new StringBuilder
    val stderr = new StringBuilder
    val status = "ls -al FRED" ! ProcessLogger(stdout append _, stderr append _)
    println(status)
    println("stdout: " + stdout)
    println("stderr: " + stderr)
  */

//  import sys.process._
//  val status = Seq("find", "/usr", "-name", "make") ! ProcessLogger(stdout
//    append _, stderr append _)
//  println(stdout)
//  println(stderr)

}
