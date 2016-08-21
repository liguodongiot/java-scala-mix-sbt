package scalacookbook.chapter12

import java.io.File

/**
  * Created by liguodong on 2016/8/7.
  */
object ListSubdirectoriesBeneathDirectory extends App {

  // assumes that dir is a directory known to exist
  def getListOfSubDirectories(dir: File): List[String] =
    dir.listFiles
      .filter(_.isDirectory)
      .map(_.getName)
      .toList

  getListOfSubDirectories(new File("G:\\githubSource")).foreach(println)


  //this method returns a List[String]. If you’d rather return a List[File],
  //write the method as follows, dropping the map method call.

  //dir.listFiles.filter(_.isDirectory).toList


  //Discussion

  // write a more Java-like (imperative) version
  def getListOfSubDirectories1(dir: File): List[String] = {
    val files = dir.listFiles
    val dirNames = collection.mutable.ArrayBuffer[String]()
    for (file <- files) {
      if (file.isDirectory) {
        dirNames += file.getName
      }
    }
    dirNames.toList
  }

  // After getting more comfortable with Scala,
  // she’d realize the code can be shortened.
  def getListOfSubDirectories2(dir: File): List[String] = {
    val files = dir.listFiles
    val dirs = for {
      file <- files
      if file.isDirectory
    } yield file.getName
    dirs.toList
  }



}
