#!/bin/sh
exec scala "$0" "$@"
!#

object Main extends App{

	println("Start...")

    import scala.sys.process._
    val strOne="ls /home/liguodong/code/".!
    println(strOne)

    println("~~~~~~~~~~~")

    val strExit=Seq("ls","-al").!
    println(strExit)

    println("~~~~~~~~~~~")

    val strExitTwo=Seq("ls","-a","-l").!
    println(strExitTwo)

    println("----------------")

    val str = "ls /home/liguodong/".!!
    val list = str.split("\n",0)
    println("list:")
    list.map(_+" ")foreach(print)

    println
    println("----------------")

    //lines已过时了
    //create a Process object to execute an external command
    val process = Process("find /home/liguodong/code/ -print").lines
    process.foreach(println)

    println("---------lineStream----------")
    //lineStream
    val processStream = Process("find /home/liguodong/code/ -print").lineStream
    processStream.foreach(println)

	println("Ending...")
}

Main.main(args)