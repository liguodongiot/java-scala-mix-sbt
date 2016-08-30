package scalacookbook.chapter01

/**
 * Created by liguodong on 2016/6/7.
 */
object OtherPartPatternString {
  def main(args: Array[String]) {
    //regular-expression groups
    val pattern = "([0-9]+) ([A-Za-z]+)".r

    //extract the regex groups from the target string
    val pattern(count, fruit) = "100 Bananas"
    println(count+":"+fruit)


    // match "movies 80301"
    val MoviesZipRE = "movies (\\d{5})".r

    // match "movies near boulder, co"
    val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r

    val array = Array("movies near 80301",
      "movies 80301",
        "80301 movies",
        "movie: 80301",
        "movies: 80301",
        "movies near boulder, co",
        "movies near boulder, colorado")


    array.foreach(textUserTyped =>
      textUserTyped match {
        case MoviesZipRE(zip) => getSearchResults(zip)
        case MoviesNearCityStateRE(city, state) => getSearchResults(city, state)
        case _ => println("did not match a regex")
      }
    )
  }

  def getSearchResults(args: String*) = {args.map(_+" ").foreach(print);println}

}
