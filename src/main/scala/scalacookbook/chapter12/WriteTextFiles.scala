package scalacookbook.chapter12

/**
  * Created by liguodong on 2016/8/3.
  */

object WriteTextFiles extends App{

  // PrintWriter
  import java.io._
  val pw = new PrintWriter(new File("D:\\hello.txt" ))
  pw.write("Hello, world")
  pw.close


  // FileWriter
  val text = "hello,world."
  val canonicalFilename = "D:\\test.txt"
  val file = new File(canonicalFilename)
  val bw = new BufferedWriter(new FileWriter(file))
  bw.write(text)
  bw.close()

}
