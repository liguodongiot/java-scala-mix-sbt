package scalacookbook.chapter02

/**
 * Created by liguodong on 2016/6/18.
 */
object FormatNumAndCurrency extends App{

  val pi = scala.math.Pi
  println(f"$pi%1.5f")
  println(f"$pi%1.2f")


  println(f"$pi%06.2f")
  println("%06.2f".format(pi))


  //A simple way to add commas is to use the getIntegerInstance method of the
  //java.text.NumberFormat class
  val formatter = java.text.NumberFormat.getIntegerInstance

  println(formatter.format(10000))


  println(formatter.format(1000000))

  //You can also set a locale with the getIntegerInstance method:
  val locale = new java.util.Locale("de", "DE")
  println(locale)

  val formatter2 = java.text.NumberFormat.getIntegerInstance(locale)
  println(formatter2.format(1000000))

  //You can handle floating-point values with a formatter returned by getInstance
  val formatter3 = java.text.NumberFormat.getInstance
  println(formatter3.format(10000.33))


  //For currency output, use the getCurrencyInstance formatter
  val formatter4 = java.text.NumberFormat.getCurrencyInstance
  println(formatter4.format(123.456789))
  println(formatter4.format(1234.56789))
  println(formatter4.format(12345.6789))
  println(formatter4.format(123456.789))


  //This approach handles international currency
  import java.util.{Currency, Locale}
  val de = Currency.getInstance(new Locale("de", "DE"))
  println(de)

  formatter4.setCurrency(de)

  println(formatter4.format(123456.789))


}
