package scalacookbook.chapter12

import java.io.File

/**
  * Created by liguodong on 2016/8/7.
  */
object ListFilesInDirectory extends App{

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)

    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  val files = getListOfFiles("E:\\study\\book")
  println(files)

  println("~~~~~~~~~~~~~~~~")

  //Discussion
  def getListOfFilesSpecified(dir: File, extensions: List[String]): List[File] =
  {
    dir.listFiles.filter(_.isFile).toList.filter { file =>
      extensions.exists(file.getName.endsWith(_))
    }
  }

  val okFileExtensions = List("wav", "mp3","rar")
  val file = new File("aaa.mvp")
  println(okFileExtensions.exists(file.getName.endsWith(_)))

  val files2 = getListOfFilesSpecified(new File("E:\\study\\book"), okFileExtensions)
  files2.foreach(println)
}


