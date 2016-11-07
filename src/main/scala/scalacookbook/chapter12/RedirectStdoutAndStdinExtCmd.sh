#!/bin/sh
exec scala "$0" "$@"
!#

object Main extends App{

	println("Start...")

	import scala.sys.process._
	import java.io.File
    //Use #> to redirect STDOUT, and #< to redirect STDIN.

    ("ls -al" #> new File("files.txt")).!
    ("ps aux" #> new File("processes.txt")).!

    //You can also pipe commands together and
    //then write the resulting output to a file
    ("ps aux" #| "grep http" #> new File("http-processes.out")).!

    val status = ("cat /etc/passwd" #> new File("passwd.copy")).!
    println(status)

    //download a URL and write its contents to a file

    import scala.language.postfixOps
    import java.net.URL

    new URL("http://www.baidu.com/") #> new File("Output.html") !

    println("================================")

    //I don’t redirect STDIN too often, but this example shows one possible way to read the
    //contents of the /etc/passwd file into a variable using #< and the Unix cat command:

    val contents = ("cat" #< new File("/etc/passwd")).!!
    println(contents)



	println("---------------------")
	//像一个管道
    val numLines = ("cat /etc/passwd" #> "wc -l").!!.trim
    println(numLines)

    // append to a file with the #>> method
    // append to a file
    ("ps aux" #>> new File("ps.out")).!

    println("Ending...")
}

Main.main(args)