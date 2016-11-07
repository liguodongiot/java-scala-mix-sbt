#!/bin/sh
exec scala "$0" "$@"
!#

object Main extends App{

	println("Start...")
    import scala.sys.process._

    val output = Process("ls -al", new File("/tmp")).!!
    println(output)

    //in the current directory
    val p = Process("ls -al")
    println(p)

    println("Ending...")
}

Main.main(args)