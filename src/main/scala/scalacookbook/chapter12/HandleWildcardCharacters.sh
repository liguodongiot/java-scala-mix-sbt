#!/bin/sh
exec scala "$0" "$@"
!#


object Main extends App{

	println("Start...")

	import scala.sys.process._
	//In general, the best thing you can do when using a wildcard character like * is to run
    //your command while invoking a Unix shell.
    //For instance, if you have .scala files in the current directory and try to list them with the following command,
    //the command will fail.
    "ls *.scala".!

    //But by running the same command inside a Bourne shell,
    //the command now correctly shows the .scala files (and returns the exit status of the command)
    val status = Seq("/bin/sh", "-c", "ls *.scala").!
    println(status)

    //为什么通配符不能够运行成功，因为通配符需要被解释。

    "echo *".!
    //*
    //res0: Int = 0

    Seq("grep", "-i", "foo", "*.scala").!
    //grep: *.scala: No such file or directory
    //res1: Int = 2


    Seq("ls", "*.scala").!
    //ls: *.scala: No such file or directory
    //res2: Int = 1

    //you can make these commands work by invoking a shell in the first two parameters to a Seq.
    val status1 = Seq("/bin/sh", "-c", "echo *").!
    val status2 = Seq("/bin/sh", "-c", "ls *.scala").!
    val status3 = Seq("/bin/sh", "-c", "grep -i foo *.scala").!

    //作为一般规则的例外，find命令的 -name 选项参数 能够运行。
    //因为他把*符号作为通配符本身。
    val status4 = Seq("find", ".", "-name", "*.scala", "-type", "f").!

    println("Ending...")

}

Main.main(args)