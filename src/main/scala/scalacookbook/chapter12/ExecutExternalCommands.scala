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


}
