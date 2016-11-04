package scalacookbook.chapter12

import java.io._

/**
  * serialize a Scala class and save it as a file, or send it across a network.
  *
  *
  * Created by liguodong on 2016/8/7.
  */

//To make a Scala class serializable, extend the Serializable trait and add the
//@SerialVersionUID annotation to the class:
//@SerialVersionUID(100L)
//class Stock(var symbol: String, var price: BigDecimal)
//  extends Serializable {
//
//}
// 继承另外一个类
//Because Serializable is a trait, you can mix it into a class, even if your class already
//  extends another class:
//@SerialVersionUID(114L)
//class Employee extends Person with Serializable {
//
//}




// create a serializable Stock class
@SerialVersionUID(123L)
class Stock(var symbol: String, var price: BigDecimal)
  extends Serializable {
  override def toString = f"$symbol%s is ${price.toDouble}%.2f"
}

object UseSerialization extends App {

  // (1) create a Stock instance
  val nflx = new Stock("NFLX", BigDecimal(85.00))

  // (2) write the instance out to a file
  val oos = new ObjectOutputStream(new FileOutputStream("D:\\output.txt"))
  oos.writeObject(nflx)
  oos.close

  // (3) read the object back in
  val ois = new ObjectInputStream(new FileInputStream("D:\\output.txt"))
  val stock = ois.readObject.asInstanceOf[Stock]
  ois.close

  // (4) print the object that was read back in
  println(stock)
}