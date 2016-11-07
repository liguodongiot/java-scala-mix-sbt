package scalacookbook.chapter12

import scala.collection.mutable.ArrayBuffer
import scala._
/**
  * Created by liguodong on 2016/8/4.
  */

object HowProcessCsvFile extends App{

  println("Month, Income, Expenses, Profit")
  val bufferedSource = io.Source.fromFile("D:\\finance.csv")

  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)
    // do whatever you want with the columns here
    println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
  }
  bufferedSource.close

  println("~~~~~~~~~~~~~")
  val bufferedSource2 = io.Source.fromFile("D:\\finance.csv")
  for (line <- bufferedSource2.getLines) {
    val Array(month, revenue, expenses, profit) = line.split(",").map(_.trim)
    println(s"$month $revenue $expenses $profit")
  }
  bufferedSource2.close

  println("~~~~~~~~~~~~~")

  //If the first line of the file is a header line and you want to skip it,
  // just add drop(1) after getLines.
  val bufferedSourceHead = io.Source.fromFile("D:\\finance.csv")
  for (line <- bufferedSourceHead.getLines.drop(1)) {
    val cols = line.split(",").map(_.trim)
    // do whatever you want with the columns here
    println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
  }

  println("~~~~~~Csv~~~~~~~")
  CsvFile.foreachWay()

  println("~~~~~~~~~~~~~")
  CsvFile.usezipWithIndex()

  println("~~~~~~~~~~~~~")


  //不知道行数时
  //don’t know the number of rows ahead of time, read each row as an Array[String],
  //adding each row to an ArrayBuffer as the file is read.

  //uses the using method introduced in the Solution

  // each row is an array of strings (the columns in the csv file)
  val rows = ArrayBuffer[Array[String]]()

  // (1) read the csv data
  CsvFile.using(io.Source.fromFile("D:\\finance.csv")) { source =>
    for (line <- source.getLines) {
      rows += line.split(",").map(_.trim)
    }
  }
  // (2) print the results
  for (row <- rows) {
    println(s"${row(0)}|${row(1)}|${row(2)}|${row(3)}")
  }

}


object CsvFile{

  def foreachWay(): Unit ={
    val bufferedSource = io.Source.fromFile("D:\\finance.csv")

    val ncol = 3;
    val nrow = 4;
    //you can also write the loop as a foreach loop
    val rows= Array.ofDim[String](ncol,nrow);

    var count = 0;
    bufferedSource.getLines.foreach { line =>
      rows(count) = line.split(",").map(_.trim)
      count += 1
    }

    // print the rows
    for (i <- 0 until ncol) {
      println(s"${rows(i)(0)} ${rows(i)(1)} ${rows(i)(2)} ${rows(i)(3)}")
    }

  }

  //Rather than use a counter, you can do the same thing with the zipWithIndex method.
  def usezipWithIndex(): Unit ={
    val ncol = 3;
    val nrow = 4;
    //you can also write the loop as a foreach loop
    val rows= Array.ofDim[String](ncol,nrow);

    val bufferedSource = io.Source.fromFile("D:\\finance.csv")
    for ((line, count) <- bufferedSource.getLines.zipWithIndex) {
      rows(count) = line.split(",").map(_.trim)
    }
    bufferedSource.close

    // print the rows
    for (i <- 0 until ncol) {
      println(s"${rows(i)(0)} ${rows(i)(1)} ${rows(i)(2)} ${rows(i)(3)}")
    }

  }

  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      resource.close()
    }

}