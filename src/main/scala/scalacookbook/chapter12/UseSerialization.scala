package scalacookbook.chapter12

import java.io._

/**
  * Created by liguodong on 2016/8/7.
  */


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
  val oos = new ObjectOutputStream(new FileOutputStream("D:\\people.txt"))
  oos.writeObject(nflx)
  oos.close

  // (3) read the object back in
  val ois = new ObjectInputStream(new FileInputStream("D:\\people.txt"))
  val stock = ois.readObject.asInstanceOf[Stock]
  ois.close

  // (4) print the object that was read back in
  println(stock)
}