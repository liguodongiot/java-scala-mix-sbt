package scalacookbook.chapter07

/**
  * Created by liguodong on 2016/7/17.
  */
object ImportOneMoreMembers extends App{

  // importing one class
  import java.io.File

  /*~~~~~=====~~~~~~~~~==============~~~~~~~~=======~~~~~~~~~~~~~*/

  // import multiple classes the Java way
  import java.io.File
  import java.io.IOException
  import java.io.FileNotFoundException


  /*~~~~~=====~~~~~~~~~==============~~~~~~~~=======~~~~~~~~~~~~~*/
  // import several classes the Scala way
  import java.io.{File, IOException, FileNotFoundException}

  /*~~~~~=====~~~~~~~~~==============~~~~~~~~=======~~~~~~~~~~~~~*/

  //import everything from the java.io package
  import java.io._


  //Discussion



}
