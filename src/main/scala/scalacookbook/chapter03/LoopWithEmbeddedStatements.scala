package scalacookbook.chapter03

/**
 * Created by liguodong on 2016/6/23.
 */
object LoopWithEmbeddedStatements extends App{

  // print all even numbers
  for (i <- 1 to 10 if i % 2 == 0) println(i)

  for {
    i <- 1 to 10
    if i % 2 == 0
  } println(i)


  for {
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  } println(i)

  //Discussion

//  for (file <- files) {
//    if (hasSoundFileExtension(file) && !soundFileIsLong(file)) {
//      soundFiles += file
//    }
//  }

//  for {
//    file <- files
//    if passesFilter1(file)
//    if passesFilter2(file)
//  } doSomething(file)

}
