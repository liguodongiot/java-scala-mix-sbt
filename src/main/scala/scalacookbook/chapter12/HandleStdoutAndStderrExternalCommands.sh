#!/bin/sh
exec scala "$0" "$@"
!#


object Main extends App{

	println("Start...")

	import scala.sys.process._

    val stdout = new StringBuilder
    val stderr = new StringBuilder
    //通过ProcessLogger捕获输出
    val status = "ls -al FRED" ! ProcessLogger(stdout append _, stderr append _)
    println(status)
    println("stdout: " + stdout)
    println("stderr: " + stderr)


    println("-------------------------")

    val status2 = Seq("find", "/usr", "-name", "make") ! ProcessLogger(stdout.append(_).append(","), stderr.append(_).append(","))
    println(status2)
    println("stdout: " +stdout)
    println("stderr: " +stderr)



    println("Ending...")

}

Main.main(args)