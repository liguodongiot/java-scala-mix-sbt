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

  val files = getListOfFiles("G:\\githubSource")

  println(files)

  //Discussion
  def getListOfFiles2(dir: File, extensions: List[String]): List[File] =
  {
    dir.listFiles.filter(_.isFile).toList.filter { file =>
      extensions.exists(file.getName.endsWith(_))
    }
  }

  val okFileExtensions = List("wav", "mp3","rar")
  val files2 = getListOfFiles2(new File("G:\\githubSource"), okFileExtensions)
  files2.foreach(println)
}


