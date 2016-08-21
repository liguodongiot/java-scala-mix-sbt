package scalacookbook.chapter06

import javax.sound.sampled.{TargetDataLine, DataLine}

/**
 * Created by liguodong on 2016/7/9.
 */
object ScalaEquivalentJavaClass extends App{


  //how to pass a class of type TargetDataLine to a method named DataLine.Info
  val info = new DataLine.Info(classOf[TargetDataLine], null)

  // java
  //info = new DataLine.Info(TargetDataLine.class, null);


  //how to access the methods of the String class
  val stringClass = classOf[String]

  stringClass.getMethods



}
