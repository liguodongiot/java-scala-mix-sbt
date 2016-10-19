package scalacookbook.chapter12

import scala._
/**
  * Created by liguodong on 2016/8/4.
  */
object HowProcessEveryCharacterTextFile extends App{

  val source = io.Source.fromFile("D:\\people.txt")
  for (char <- source) {
    println(char.toUpper)
  }
  source.close

  //However, be aware that this code may be slow on large files.
  //对于大文件的处理太慢

  println("```````````````")


  // the following method that counts the number of lines in a file
  // takes 100 seconds to run on an Apache
  // access logfile that is ten million lines long.



  // run time: took 100 secs
  def countLines1(source: io.Source): Long = {
    val NEWLINE = 10
    var newlineCount = 0L
    for {
      char <- source
      if char.toByte == NEWLINE
    } newlineCount += 1
    newlineCount
  }


  //The time can be significantly reduced by using
  // the getLines method to retrieve one
  // line at a time, and then working through the characters in each line.

  //The following linecounting algorithm counts the same
  // ten million lines in just 23 seconds.

  // run time: 23 seconds
  // use getLines, then count the newline characters
  // (redundant for this purpose, i know)
  def countLines2(source: io.Source): Long = {
    //ASCII字符表中  10-->0A	 表示 换行/新行
    val NEWLINE = 10
    var newlineCount = 0L
    for {
      line <- source.getLines
      c <- line
      if c.toByte == NEWLINE
    } newlineCount += 1
    newlineCount
  }


  //双重for循环 等价于 上面的方式 ，但是上面更简洁
  def countLines3(source: io.Source): Long = {

    //ASCII字符表中  10-->0A	 表示 换行/新行
    val NEWLINE = 10
    var newlineCount = 0L
    for (line <- source.getLines) {
      for {
        c <- line
        if c.toByte == NEWLINE
      } newlineCount += 1
    }
    newlineCount
  }




}
