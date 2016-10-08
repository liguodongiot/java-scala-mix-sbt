package scalacookbook.chapter06

import org.springframework.context.support.ClassPathXmlApplicationContext
import scalacookbook.chapter17.Animal

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
  val ctx = new ClassPathXmlApplicationContext("scalacookbook/applicationContext.xml")

  // instantiate our dog and cat objects from the application context
  val dog = ctx.getBean("dog").asInstanceOf[Animal]
  val cat = ctx.getBean("cat").asInstanceOf[Animal]

  // let them speak
  dog.speak
  cat.speak

  // reading a YAML configuration file
  //val yaml = new Yaml(new Constructor(classOf[EmailAccount]))
  //val emailAccount = yaml.load(text).asInstanceOf[EmailAccount]

  //val cm = new ConfigurationManager("config.xml")
  // instance of Recognizer
  //val recognizer = cm.lookup("recognizer").asInstanceOf[Recognizer]
  // instance of Microphone
  //val microphone = cm.lookup("microphone").asInstanceOf[Microphone]

  val a = 10  //a: Int = 10

  val b = a.asInstanceOf[Long]  //b: Long = 10

  val c = a.asInstanceOf[Byte]  //c: Byte = 10

  // when you need to interact with Java and send it an array of Object instances
  val objects = Array("a", 1)
  val arrayOfObject = objects.asInstanceOf[Array[Object]]
  AJavaClass.sendObjects(arrayOfObject)


  import java.net.{URL, HttpURLConnection}
  val url = " http://www.baidu.com"
  val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]


  val i = 1
  //i.asInstanceOf[String] //ClassCastException: java.lang.Integer cannot be cast to java.lang.String


}
