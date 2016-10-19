package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/7.
 */
object PatternString {

  def main(args: Array[String]) {
    val numPattern = "[0-9]+".r

    val address = "123 Main Street Suite 101"

    val match1 = numPattern.findFirstIn(address)
    println(match1)

    val matches = numPattern.findAllIn(address)
    matches.foreach(println)

    // If there are no matches, this approach yields an empty Array.
    // Other methods like toList, toSeq, and toVector are also available.
    val matches2 = numPattern.findAllIn(address).toArray


    println("===~~~~===~~~~===~~~~===~~~~~====")

    //Another approach is to import the Regex class, create a Regex instance
    import scala.util.matching.Regex
    val numPattern2 = new Regex("[0-9]+")
    val address2 = "123 Main Street Suite 101"
    val match2 = numPattern2.findFirstIn(address2)
    println(match2)

    val result = numPattern.findFirstIn(address).getOrElse("no match")

    match1 match{
      case Some(s) => println(s"Found:$s")
      case None => println("Nonono...")
    }

    println("===~~~~===~~~~===~~~~===~~~~~====")

    val numPattern3 = "[0-9]+".r
    val address3 = "123 Main Street Suite 101"
    val match3 = numPattern3.findFirstIn(address3)
    match1.foreach { e => println(s"Found a match: $e")}
  }
}
