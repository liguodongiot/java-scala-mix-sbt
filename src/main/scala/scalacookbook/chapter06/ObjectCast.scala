package scalacookbook.chapter06

/**
 * Created by liguodong on 2016/7/5.
 */
object ObjectCast extends App{



  //Scala
  //val recognizer = cm.lookup("recognizer").asInstanceOf[Recognizer]

  //Java
  //Recognizer recognizer = (Recognizer)cm.lookup("recognizer");



  //Discussion

  // open/read the application context file
  //val ctx = new ClassPathXmlApplicationContext("applicationContext.xml")

  // instantiate our dog and cat objects from the application context
  //val dog = ctx.getBean("dog").asInstanceOf[Animal]
  //val cat = ctx.getBean("cat").asInstanceOf[Animal]



  //val cm = new ConfigurationManager("config.xml")
  // instance of Recognizer
  //val recognizer = cm.lookup("recognizer").asInstanceOf[Recognizer]
  // instance of Microphone
  //val microphone = cm.lookup("microphone").asInstanceOf[Microphone]

  val a = 10

  val b = a.asInstanceOf[Long]

  val c = a.asInstanceOf[Byte]

  // when you need to interact with Java and send it an array of Object instances
//  val objects = Array("a", 1)
//  val arrayOfObject = objects.asInstanceOf[Array[Object]]
//  AJavaClass.sendObjects(arrayOfObject)


  import java.net.{URL, HttpURLConnection}
  val url = "www.google.com"
  val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]


  val i = 1
  //i.asInstanceOf[String] //ClassCastException: java.lang.Integer cannot be cast to java.lang.String


}
