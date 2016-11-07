#!/bin/sh
exec scala "$0" "$@"
!#

object Main extends App{

	println("Start...")


    import scala.sys.process._
    //val num = ("tar -zxvf /home/liguodong/install/hadoop-2.6.0-64.tar.gz").!
    //println(num)
    //val mvResult = ("mv /home/liguodong/code/hadoop-2.6.0 /home/liguodong/code/scala/hadoop" ).!
    //println(mvResult)

    //在Scala中使用#&& 和 #||，就像Unix中使用&& 和 ||

    //Run the ls command on the file temp, and if it’s found,
    //remove it, otherwise, print the ‘not found’ message.
    val result = ("ls temp" #&& "rm temp" #|| "echo 'temp' not found").!!.trim
    println(result)

    println("==============")

    ("ls *.scala" #&& "scalac *.scala" #|| "echo no files to compile").!

    println("--------------")
    val filesExist = Seq("/bin/sh", "-c", "ls *.scala")
    val compileFiles = Seq("/bin/sh", "-c", "scalac *.scala")
    (filesExist #&& compileFiles #|| "echo no files to compile").!!

    println("Ending...")
}

Main.main(args)