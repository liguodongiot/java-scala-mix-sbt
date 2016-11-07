#!/bin/sh
exec scala "$0" "$@"
!#

object Main extends App{

	println("Start...")

	import scala.sys.process._

	val result = "ls -al".!!
    println(result)

    //If you prefer, you can do the same thing with a Process or Seq instead of a String:
    //val result = Process("ls -al").!!
    //val result = Seq("ls -al").!!

    //使用Seq是一个好方法
    //val output = Seq("ls", "-al").!!
    //val output = Seq("ls", "-a", "-l").!!
    //val output = Seq("ls", "-a", "-l", "/tmp").!!

    // The following code segment shows how to run a complex Unix find command
    val dir = "/home/liguodong/data"
    val searchTerm = "dawn"

    val results = Seq("find", dir, "-type", "f", "-exec", "grep", "-il",
    searchTerm, "{}", ";").!!
    println(results)

    //代码等效于在Unix运行以下 find 命令
    // find /home/liguodong/data -type f -exec grep -il dawn {} \;
    //这个命令读取/liguodong/data目录下所有文件 包含字符串dawn,并打印文件名。

    println("----------------------")

    //Discussion

    //Use the ! method to get the exit code from a process,
    //or !! to get the standard output from a process.

    //val out = "ls -l fred".!
    //println(out)

    //ls: fred: No such file or directory
    //out: Int = 1

    //val out2 = "ls -l fred".!!
    //println(out2)

    //ls: fred: No such file or directory
    //java.lang.RuntimeException: Nonzero exit value: 1
    //many more lines of output ...

    println("~~~~~~~~~~~~~~~~~")


    //Unexpected newline characters

    val dirCur = "pwd".!!
    println(dirCur)

    val dirCurTrim = "pwd".!!.trim
    println(dirCurTrim)

    println("----------------------------")
    //Using the lines_! method

    //检查一个可执行程序是否在你的系统之中，如果非零表示在当前系统不可用。
    //更确切的说，可能在系统中，不在环境变量PATH中。
    val executable = "which hadoop2".!
    println(executable)

    //Another way to handle this situation is to use the lines_! method.
    //This can be used to return a Some or None.
    val executableLines = "which hadoop2".lines_!.headOption
    println(executableLines)

    val executableLines2 = "which ls".lines_!.headOption
    println(executableLines2)

    //注：
    //Note the call to the headOption method at the end of this pipeline. You call this method
    //because the lines_! method returns a Stream, but you want the Option immediately.


	println("Ending...")
}

Main.main(args)