package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/5.
 */
object Main {

  def main(args: Array[String]) {

    val temp = "Hello,Scala"
    println(temp.getClass.getName)
    println(temp.length)
    temp.foreach(print _)
    println
    temp.map(_+" ").foreach(print)

    for(c <- temp){
      print(c+" ")
    }
    println

    temp.getBytes.map(_+" ").foreach(print)
    println

    temp.filter(_!='l').map(_+" ").foreach(print)
    println

    println("liguodong".drop(2).take(2).capitalize)



  }
}
