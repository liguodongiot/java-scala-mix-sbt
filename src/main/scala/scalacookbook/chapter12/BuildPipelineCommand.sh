#!/bin/sh
exec scala "$0" "$@"
!#

object Main extends App{

	println("Start...")

	import scala.sys.process._

    //使用 #| 方法，从一个管道输出作为另一个管道的输入

    //When doing this, use ! at the end of the pipeline
    //if you want the exit code of the pipeline, or !! if you want the output from the pipeline.
    //ps auxw | wc -l

    val numProcs = ("ps auxw" #| "wc -l").!!.trim
    println(s"#procs = $numProcs")

    val javaProcs = ("ps auxw" #| "grep java").!!.trim
    println(s"#javaProcs = $javaProcs")

    println("-----------------")

    try {
        val r = Seq("/bin/sh", "-c", "ls | grep .scala").!!
        println(r)

        val rTrim = Seq("/bin/sh", "-c", "ls | grep .scala").!!.trim
        println(rTrim)

    } catch {
     case ex: Exception => println("Exception..."+ex)
    }



    //However, note that when using !!, you’ll get the following exception if there are
    //no .scala files in the directory:
    //java.lang.RuntimeException: Nonzero exit value: 1
    //I’ve found it best to wrap commands executed with !! in a try/catch expression.

	println("Ending...")
}

Main.main(args)