package scalacookbook.chapter17

import java.io.IOException
import javax.sound.sampled.{LineUnavailableException, UnsupportedAudioFileException}

/**
  * Created by liguodong on 2016/8/19.
  */

//add an @throws annotation to let callers know that
// the exceptionThrower method can throw an Exception
// scala
class Thrower {
  @throws(classOf[Exception])
  def exceptionThrower {
    throw new Exception("Exception!")
  }

  //want to declare that your Scala method throws multiple exceptions,
  // add an annotation for each exception
  @throws(classOf[IOException])
  @throws(classOf[LineUnavailableException])
  @throws(classOf[UnsupportedAudioFileException])
  def playSoundFileWithJavaAudio {
    // exception throwing code here ...
  }

}