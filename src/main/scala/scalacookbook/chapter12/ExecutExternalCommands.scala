package scalacookbook.chapter12

/**
  * Created by liguodong on 2016/8/8.
  */
object ExecutExternalCommands extends App{

  import sys.process._
  "ls -al".!

  println("~~~~~~~~~~~~~~")

  val exitCode = "ls -al".!
  println("~~~~~~"+exitCode)

  //Discussion
  def playSoundFile(filename: String): Int = {
    val cmd = "afplay " + filename
    val exitCode = cmd.!
    exitCode
  }

  val exitCode11 = Seq("ls", "-al").!
  val exitCode12 = Seq("ls", "-a", "-l").!
  val exitCode13 = Seq("ls", "-a", "-l", "G:\\study").!
  val exitCode14 = Process("ls").!

  println("====================")

  //Using the lines method
  val process = Process("ls").lines

  process.foreach(println)

  //External commands versus built-in commands
  //外部命令与内置命令

  //最后一点，你可以在Scala中运行任何Unix命令行的外部命令，
  //然而外部命令和shell内置命令之间有一个很大的不同。
  //Unix系统的外部命令 ls 能发现是在 /bin 目录下。

  //许多其他被Unix运行的命令，例如 cd 或 for 在Bash shell中。
  // 在文件系统中，你不能发现他们作为一个文件。
  //因此他们不能被执行，除非他们被执行在一个shell中。

}
